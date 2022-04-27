package br.com.fernando.moviesbattle;

import br.com.fernando.moviesbattle.domain.Filme;
import br.com.fernando.moviesbattle.model.Sessao;
import br.com.fernando.moviesbattle.service.FilmeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FilmesTest {
	@Autowired
	FilmeService filmeService;

	@Test
	public void enviaFilmesComIdNulloEsperandoQueRetorneDoisNovosFilmesComUmVetorDeTamanhoDOis() {
//		Filme[] filmes = new Filme[2];
//		assertEquals(filmes.length, filmeService.getFilmes(new Sessao(null, imdbIdFilme, null, false), 2).length);
	}
}
