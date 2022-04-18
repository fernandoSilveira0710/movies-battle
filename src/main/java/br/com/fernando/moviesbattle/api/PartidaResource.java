package br.com.fernando.moviesbattle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.moviesbattle.domain.Filme;
import br.com.fernando.moviesbattle.model.Partida;
import br.com.fernando.moviesbattle.model.Sessao;
import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.service.FilmeService;
import br.com.fernando.moviesbattle.service.PartidaService;
import br.com.fernando.moviesbattle.service.UsuarioService;

@RestController
@RequestMapping("api/partida")
public class PartidaResource {
	@Autowired
	PartidaService partService;

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	FilmeService filmeService;

	/*
	 * validar acesso e verifica se a partida ta ativo
	 */

	@GetMapping("/novo/{nick}/{senha}")
	@ResponseBody
	public ResponseEntity<Partida> iniciarPartida(@PathVariable String nick, @PathVariable String senha) {
		Usuario usuario = usuarioService.login(nick, senha);
		if (usuario != null) {
			if (!usuario.getPartida().isAtivo() && usuario.getPartida().getSessao() == null) {
				usuario.getPartida().setAtivo(true);
				usuario.getPartida().setPontos(0);
				usuario.getPartida().setVidas(3);
				usuarioService.create(usuario);
				return ResponseEntity.ok().eTag("Partida iniciada " + usuario.getPartida().getVidas())
						.body(usuario.getPartida());
			}
			return ResponseEntity.ok().eTag("Partida já está ativa " + usuario.getPartida().getVidas())
					.body(usuario.getPartida());
		}
		return ResponseEntity.notFound().eTag("Usuário não encontrado.").build();
	}

	/**
	 * get partida mando 2 filmes [AB,CD,AD]
	 */
	@GetMapping("/{nick}/{senha}")
	@ResponseBody
	public ResponseEntity<Filme[]> partida(@PathVariable String nick, @PathVariable String senha) {
		Usuario usuario = usuarioService.login(nick, senha);
		Filme[] filmes = new Filme[2];
		if (usuario != null) {
			if(usuario.getPartida().isAtivo()) {
				if ( usuario.getPartida().getSessao() != null) {
					filmes = filmeService.getFilmes(usuario.getPartida().getSessao(), 2);
					return ResponseEntity.ok().eTag("Partida iniciada " + usuario.getPartida().getVidas()).body(filmes);
				} else {
					filmes = filmeService.getFilmes(null, 2);
					usuario.getPartida().setSessao(new Sessao(filmes[0].getImdbID(), filmes[1].getImdbID(), false));
					usuarioService.create(usuario);
					return ResponseEntity.ok().eTag("Partida iniciada " + usuario.getPartida().getVidas()).body(filmes);
				}
			}else {
				return ResponseEntity.notFound().eTag("Partida não iniciada.").build();
			}

		}
		return ResponseEntity.notFound().eTag("Usuário não encontrado.").build();
	}

	/*
	 * post partida receber dois filmes com um selecionado +1 ponto ranking -1 vida
	 * e verifica se ela é maior que 0 // encerro jogo
	 * 
	 */

	/*
	 * encerra-partida get encerra jogo verifica
	 */
	@GetMapping("/encerrar/{nick}/{senha}")
	@ResponseBody
	public ResponseEntity<Partida> encerrarPartida(@PathVariable String nick, @PathVariable String senha) {
		Usuario usuario = usuarioService.login(nick, senha);
		if (usuario != null) {
			if (usuario.getPartida().isAtivo()) {
				usuario.getPartida().setAtivo(false);
				usuario.getPartida().setPontos(0);
				usuario.getPartida().setVidas(3);
				usuario.getPartida().setSessao(null);
				usuarioService.create(usuario);
				return ResponseEntity.ok().eTag("Partida encerrada " + usuario.getPartida().getVidas())
						.body(usuario.getPartida());
			}
			return ResponseEntity.ok().eTag("Partida já está encerrada " + usuario.getPartida().getVidas())
					.body(usuario.getPartida());
		}
		return ResponseEntity.notFound().eTag("Usuário não encontrado.").build();
	}

}
