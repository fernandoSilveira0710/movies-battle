package br.com.fernando.moviesbattle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.moviesbattle.model.Partida;
import br.com.fernando.moviesbattle.repository.PartidaRepository;

@Service
public class PartidaService {
	@Autowired
	PartidaRepository repository;
	
	public boolean update(Partida partida) {
		return (partida != null) ?
				repository.save(partida).isAtivo() :
					null;
	}
	
	
}
