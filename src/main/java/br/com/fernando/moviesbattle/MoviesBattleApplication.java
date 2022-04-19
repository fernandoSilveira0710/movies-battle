package br.com.fernando.moviesbattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class MoviesBattleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesBattleApplication.class, args);

	}
}
