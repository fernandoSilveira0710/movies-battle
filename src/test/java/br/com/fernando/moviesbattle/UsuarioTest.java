package br.com.fernando.moviesbattle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fernando.moviesbattle.model.Partida;
import br.com.fernando.moviesbattle.model.Ranking;
import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.service.UsuarioService;

@SpringBootTest
public class UsuarioTest {
	@Autowired
	UsuarioService usuarioService;

	@Test
	public void validaUsuarioRecebendoOObjetoERetornandoTrueCasoTodosOsCamposEstejamPreenchidos() {
		Usuario usuario = new Usuario("teste", "teste", new Ranking(0, 10, 0.0));
		usuario.setPartida(new Partida(0, true, 5));

		assertEquals(true, usuarioService.valida(usuario));
		;
	}
}
