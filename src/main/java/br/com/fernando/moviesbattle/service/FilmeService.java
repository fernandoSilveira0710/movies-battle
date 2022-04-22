package br.com.fernando.moviesbattle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fernando.moviesbattle.domain.Filme;
import br.com.fernando.moviesbattle.dto.Resposta;
import br.com.fernando.moviesbattle.model.Sessao;
import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.rest.PesquisaRest;
import br.com.fernando.moviesbattle.utils.Const;
import br.com.fernando.moviesbattle.utils.Util;

@Service
public class FilmeService {

	public List<Filme> getFilmes(Sessao sessao) {
		return (sessao != null) ? sessao.getImdbIdFilmes() : comparaFilmes(sessao);
	}

	private List<Filme> comparaFilmes(Sessao sessao) {
		List<Filme> filmes = new ArrayList<>();

		for (int i = 0; filmes.size() < ((sessao != null) ? sessao.getTamanho() : 2); i++) {
			filmes.add(i, getFilme());
			filmes = filmes.stream().distinct().collect(Collectors.toList());
		}
		return filmes;
	}

	private Filme getFilme() {
		return PesquisaRest.buscaPorId(Const.imdbIds.get(Util.geraNumerosRandom(0, 250)));
	}

	public String verificaRatingImdbFilme(Usuario usuario, Resposta resposta) {
		List<Filme> filmes = usuario.getPartida().getSessao().getImdbIdFilmes();

		if (!filmes.isEmpty() && filmes.size() == usuario.getPartida().getSessao().getTamanho()) {
			try {
				double imdbRating1 = Double.parseDouble(filmes.get(0).getImdbRating());
				double imdbRating2 = Double.parseDouble(filmes.get(1).getImdbRating());

				boolean resp = imdbRating1 > imdbRating2;
				System.err.println(resp);
				return (resp == resposta.resposta) ? "1" : "2";
			} catch (Exception e) {
				return "3";
			}
		} else {
			return "3";
		}
	}
}
