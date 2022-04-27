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

    @Override
    public void run(String... args) {

        if(userService.findAll().isEmpty()) {

            Usuario user1 = new Usuario("user1", "123", new Ranking(0, 0, 0.0));
            Usuario user2 = new Usuario("user2", "456", new Ranking(10, 0, 0.0));
            Usuario user3 = new Usuario("user3", "789", new Ranking(500, 0, 0.0));
            Usuario user4 = new Usuario("user4", "012", new Ranking(735, 0, 0.0));
            Usuario user5 = new Usuario("user5", "345", new Ranking(24, 0, 0.0));

            user1.setPartida(new Partida(3, true, 0));
            user4.setPartida(new Partida(3, true, 0));

            userService.create(user1);
            userService.create(user2);
            userService.create(user3);
            userService.create(user4);
            userService.create(user5);

        }


    }


}
