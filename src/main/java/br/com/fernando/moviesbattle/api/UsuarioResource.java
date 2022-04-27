package br.com.fernando.moviesbattle.api;

import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "usuario")
@RestController
@RequestMapping("api/usuarios")
public class UsuarioResource {
	@Autowired
	UsuarioService service;

	@ApiOperation(value = "Lista todos os usuarios cadastrados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista os usuarios e seu tamanho"),
			@ApiResponse(code = 404, message = "Lista usuarios vazia") })
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = service.findAll();
		return (list.isEmpty()) ? ResponseEntity.notFound().eTag("Usuario não contem registros.").build()
				: ResponseEntity.ok().eTag("Usuario contém " + list.size() + " registros.").body(list);
	}
}
