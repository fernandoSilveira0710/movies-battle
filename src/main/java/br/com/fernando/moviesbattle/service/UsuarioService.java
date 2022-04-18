package br.com.fernando.moviesbattle.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;

	@Transactional
	public boolean create(Usuario usuario) {
		if (valida(usuario)) {
			repository.save(usuario);
			return true;
		}
		return false;
	}

	public boolean valida(Usuario usuario) {
		List<Boolean> validacao = new ArrayList<>();
		validacao.add((usuario.getNick() != null));
		validacao.add((usuario.getSenha() != null));
		validacao.add((!usuario.getNick().equals("")));
		validacao.add((!usuario.getSenha().equals("")));
		return validacao.stream().allMatch(e -> e.booleanValue() == true);// verifica se todos os indices são true
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario login(String nick, String senha) {
		return (!nick.equals("") && !senha.equals("")) ? repository.findByNickAndSenha(nick, senha) : null;
	}
}
