package br.com.fernando.moviesbattle;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fernando.moviesbattle.model.Partida;
import br.com.fernando.moviesbattle.model.Ranking;
import br.com.fernando.moviesbattle.model.Sessao;
import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.rest.PesquisaRest;
import br.com.fernando.moviesbattle.service.FilmeService;
import br.com.fernando.moviesbattle.service.RankingService;
import br.com.fernando.moviesbattle.service.UsuarioService;
import br.com.fernando.moviesbattle.utils.Const;
import br.com.fernando.moviesbattle.utils.Util;

@SpringBootApplication
public class MoviesBattleApplication implements CommandLineRunner {

	@Autowired
	UsuarioService userService;

	@Autowired
	RankingService rankingService;
	
	@Autowired
	FilmeService filmeService;

	public static void main(String[] args) {
		SpringApplication.run(MoviesBattleApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Usuario user1 = new Usuario();
		user1.setNick("feelpa");
		user1.setSenha("1234");

		Ranking ranking = new Ranking();
		ranking.setPontuacao(10);
		user1.setRanking(ranking);
		Partida partida = new Partida();
		partida.setAtivo(false);
		partida.setPontos(0);
		partida.setVidas(1);
		user1.setPartida(partida);

		partida.setUsuario(user1);
		ranking.setUsuario(user1);

		Usuario user2 = new Usuario();
		user2.setNick("ze");
		user2.setSenha("123");
		user2.setRanking(new Ranking(0, 0, 0.0));

		userService.create(user1);
		userService.create(user2);
		
		
		filmeService.getFilmes(new Sessao("tt0108052", "tt0180093", false), 2);
		
		
	}

}
