package br.com.fernando.moviesbattle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		try {
			validacao.add((usuario.getNick() != null));
			validacao.add((usuario.getSenha() != null));
			validacao.add((!usuario.getNick().equals("")));
			validacao.add((!usuario.getSenha().equals("")));
		} catch (Exception e2) {
			validacao.add(false);
		}
		return validacao.stream().allMatch(e -> e);// verifica se todos os indices são true
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Optional<Usuario> findById(Long id) {
		return repository.findById(id);
	}

	public Usuario login(String nick, String senha) {
		return (!nick.isEmpty() && !senha.isEmpty()) ? repository.findByNickAndSenha(nick, senha) : null;
	}
}
