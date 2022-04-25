package br.com.fernando.moviesbattle.api;

import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.service.UsuarioService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "login")
@RestController
@RequestMapping("api/login")
public class LoginResource {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/{user}/{password}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody
	public ResponseEntity<Usuario> login(@PathVariable(value = "user") String user,@PathVariable(value = "password") String password) {
		Usuario usuario = usuarioService.login(user, password);
		return (usuario != null) ? ResponseEntity.ok().eTag("Usuario logado " + usuario.getUser()).body(usuario)
				: ResponseEntity.notFound().eTag("Usuário não encontrado.").build();
	}

}
