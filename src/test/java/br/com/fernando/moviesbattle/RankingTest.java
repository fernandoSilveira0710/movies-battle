package br.com.fernando.moviesbattle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fernando.moviesbattle.service.RankingService;

@SpringBootTest
public class RankingTest {
	@Autowired
	RankingService rankingService;
	
	@Test
	public void teste() {
		//nada por aqui
	}
}
