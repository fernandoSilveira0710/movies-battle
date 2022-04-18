package br.com.fernando.moviesbattle.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.service.UsuarioService;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioResource {
	@Autowired
	UsuarioService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		if (list != null) {
			return (list.size() <= 0) ? ResponseEntity.notFound().eTag("Usuario não contem registros.").build()
					: ResponseEntity.ok().eTag("Usuario contém " + list.size() + " registros.").body(list);
		}
		return ResponseEntity.notFound().eTag("Usuario não contem registros.").build();
	}
}
