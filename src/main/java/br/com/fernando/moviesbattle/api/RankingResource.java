package br.com.fernando.moviesbattle.api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.moviesbattle.dto.GenericRanking;
import br.com.fernando.moviesbattle.model.Ranking;
import br.com.fernando.moviesbattle.service.RankingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "ranking", description = "Lista o ranking")
@RestController
@RequestMapping("api/ranking")
public class RankingResource {

	@Autowired
	RankingService service;

	@ApiOperation(value = "Lista o ranking completo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ranking com o tamanho de tal"),
			@ApiResponse(code = 404, message = "Ranking sem registros") })
	@GetMapping("/all")
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

	@ApiOperation(value = "Lista o ranking ordenado com limite de 10")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listar os 10 melhores nas pontuações"),
			@ApiResponse(code = 404, message = "ranking sem registros") })
	@GetMapping("")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<GenericRanking>> list() {
		List<Ranking> list = service.findAll();
		if (list != null) {
			List<GenericRanking> listGeneric = service.sortList(list);
			List<GenericRanking> listOrdenada = listGeneric.stream()
					.sorted(Comparator.comparingInt(GenericRanking::getPontuacao).reversed()).limit(10)
					.collect(Collectors.toList());
			System.err.println(listOrdenada);
			return ResponseEntity.ok().eTag("Ranking dos 10 melhores").body(listOrdenada);
		}
		return ResponseEntity.notFound().eTag("Ranking não contem registros.").build();
	}

}
