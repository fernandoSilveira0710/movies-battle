package br.com.fernando.moviesbattle;

import br.com.fernando.moviesbattle.model.Partida;
import br.com.fernando.moviesbattle.model.Ranking;
import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.service.PartidaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PartidaTest {
    @Autowired
    PartidaService partidaService;

    @Test
    public void calculaAPontuacaoMultiplicandoPontosEDividindoPelaSequenciaDOQUizRetornandoUmNumeroDouble() {
        Usuario usuario = new Usuario(null, null, new Ranking(0, 10, 0.0));
        usuario.setPartida(new Partida(0, true, 5));

        assertEquals(500.0, partidaService.calcularPontuacao(usuario));
    }
}
