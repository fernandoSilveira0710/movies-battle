package br.com.fernando.moviesbattle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.moviesbattle.model.Partida;
import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.repository.PartidaRepository;

@Service
public class PartidaService {
	@Autowired
	PartidaRepository repository;

	public boolean update(Partida partida) {
		return (partida != null) ? repository.save(partida).isAtivo() : null;
	}

	public Double calcularPontuacao(Usuario usuario) {
		Integer pontos = (usuario.getPartida().getPontos() * 100) / usuario.getRanking().getSequenciaQuiz();
		usuario.getRanking().setPorcentagemAcerto(pontos.doubleValue());
		Double pontuacao = (usuario.getRanking().getSequenciaQuiz() * usuario.getRanking().getPorcentagemAcerto());
		usuario.getRanking().setPontuacao(usuario.getRanking().getPontuacao() + pontuacao.intValue());
		return pontuacao;
	}

}
