package br.com.fernando.moviesbattle;

import br.com.fernando.moviesbattle.service.RankingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RankingTest {
	@Autowired
	RankingService rankingService;
	
	@Test
	public void teste() {
		//nada por aqui
	}
}
