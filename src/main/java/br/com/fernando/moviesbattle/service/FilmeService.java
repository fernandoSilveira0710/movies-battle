package br.com.fernando.moviesbattle.service;

import java.util.ArrayList;
import java.util.List;

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

	public Filme[] getFilmes(Sessao sessao, int tamanho) {
		Filme[] filmes = new Filme[tamanho];
		if (sessao != null) {
			if (!sessao.isRespondido()) {
				filmes[0] = PesquisaRest.buscaPorId(sessao.getImdbIdFilme1());
				filmes[1] = PesquisaRest.buscaPorId(sessao.getImdbIdFilme2());
			} else {
				filmes = comparaFilmes(sessao);
			}
		} else {
			filmes = comparaFilmes(sessao);
		}
		return filmes;
	}

	private Filme[] comparaFilmes(Sessao sessao) {
		Filme[] filmes = new Filme[2];
		System.err.println("COMPARA");
		while (true) {
			filmes[0] = getFilme();
			do {
				filmes[1] = getFilme();
			} while (filmes[0].getImdbRating().equals(filmes[1].getImdbRating()));

			if (sessao != null) {
				if (!filmes[0].getImdbRating().equals(filmes[1].getImdbRating())) {
					if (!filmes[0].getImdbID().equals(sessao.getImdbIdFilme1())
							&& !filmes[0].getImdbID().equals(sessao.getImdbIdFilme2())
							&& !filmes[1].getImdbID().equals(sessao.getImdbIdFilme1())
							&& !filmes[1].getImdbID().equals(sessao.getImdbIdFilme2())) {
						System.out.println("NÃO SÃO IGUAIS");
						break;
					} else {
						continue;
					}
				}
			}
			break;
		}
		return filmes;
	}

	private Filme getFilme() {
		return PesquisaRest.buscaPorId(Const.imdbIds.get(Util.geraNumerosRandom(0, 250)));
	}

	public String verificaRatingImdbFilme(Usuario usuario, Resposta resposta) {
		List<Filme> filmes = new ArrayList<>();
		filmes.add(PesquisaRest.buscaPorId(usuario.getPartida().getSessao().getImdbIdFilme1()));
		filmes.add(PesquisaRest.buscaPorId(usuario.getPartida().getSessao().getImdbIdFilme2()));

		if (!filmes.isEmpty() && filmes.size() == 2) {
			try {
				double imdbRating1 = Double.parseDouble(filmes.get(0).getImdbRating());
				double imdbRating2 = Double.parseDouble(filmes.get(1).getImdbRating());

				boolean resp = (imdbRating1 > imdbRating2) ? true : false;
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
