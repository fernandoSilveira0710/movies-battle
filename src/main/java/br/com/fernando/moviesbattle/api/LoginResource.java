package br.com.fernando.moviesbattle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.service.UsuarioService;
import io.swagger.annotations.Api;

@Api(value = "login", description = "Realiza o login do usuário")
@RestController
@RequestMapping("api/login")
public class LoginResource {
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/{nick}/{senha}")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<Usuario> login(@PathVariable(value = "nick") String nick,
			@PathVariable(value = "senha") String senha) {
		Usuario usuario = usuarioService.login(nick, senha);
		return (usuario != null) ? ResponseEntity.ok().eTag("Usuario logado " + usuario.getNick()).body(usuario)
				: ResponseEntity.notFound().eTag("Usuário não encontradp.").build();
	}

}
