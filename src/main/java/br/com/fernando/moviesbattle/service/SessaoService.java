package br.com.fernando.moviesbattle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.moviesbattle.model.Sessao;
import br.com.fernando.moviesbattle.repository.SessaoRepository;

@Service
public class SessaoService {

	@Autowired
	SessaoRepository repository;

	public void delete(Sessao sessao) {
		repository.delete(sessao);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
