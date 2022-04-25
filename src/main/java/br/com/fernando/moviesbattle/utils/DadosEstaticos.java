package br.com.fernando.moviesbattle.utils;

import br.com.fernando.moviesbattle.model.Partida;
import br.com.fernando.moviesbattle.model.Ranking;
import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.service.FilmeService;
import br.com.fernando.moviesbattle.service.RankingService;
import br.com.fernando.moviesbattle.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DadosEstaticos implements CommandLineRunner {
	@Autowired
	UsuarioService userService;

	@Autowired
	RankingService rankingService;

	@Autowired
	FilmeService filmeService;

	@Override
	public void run(String... args) {
		Usuario user1 = new Usuario("user1","123",null);
		Usuario user2 = new Usuario("user2","456",null);
		Usuario user3 = new Usuario("user3","789",null);
		Usuario user4 = new Usuario("user4","012",null);
		Usuario user5 = new Usuario("user5","345",null);
		
		Ranking ranking1 = new Ranking(0, 0, 0.0);
		Ranking ranking2 = new Ranking(10, 0, 0.0);
		Ranking ranking3 = new Ranking(500, 0, 0.0);
		Ranking ranking4 = new Ranking(735, 0, 0.0);
		Ranking ranking5 = new Ranking(24, 0, 0.0);
		
		user1.setRanking(ranking1);
		user2.setRanking(ranking2);
		user3.setRanking(ranking3);
		user4.setRanking(ranking4);
		user5.setRanking(ranking5);
		
		
		Partida partida1 = new Partida(3,true,0);
		Partida partida4 = new Partida(3,true,0);
		
		user1.setPartida(partida1);
		user4.setPartida(partida4);

		partida1.setUsuario(user1);
		partida4.setUsuario(user4);
		
		ranking1.setUsuario(user1);
		ranking2.setUsuario(user2);
		ranking3.setUsuario(user3);
		ranking4.setUsuario(user4);
		ranking5.setUsuario(user5);
		
		userService.create(user1);
		userService.create(user2);
		userService.create(user3);
		userService.create(user4);
		userService.create(user5);
	}

	

}
