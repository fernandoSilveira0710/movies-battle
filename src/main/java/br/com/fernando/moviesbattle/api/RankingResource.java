package br.com.fernando.moviesbattle.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.moviesbattle.model.Ranking;
import br.com.fernando.moviesbattle.service.RankingService;

@RestController
@RequestMapping("api/ranking")
public class RankingResource {

	@Autowired
	RankingService service;

	@GetMapping()
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<Ranking>> findAll() {
		List<Ranking> list = service.findAll();
		if (list != null) {
			return (list.size() <= 0) ? ResponseEntity.notFound().eTag("Ranking não contem registros.").build()
					: ResponseEntity.ok().eTag("Ranking contém " + list.size() + " registros.").body(list);
		}
		return ResponseEntity.notFound().eTag("Ranking não contem registros.").build();

	}
}
