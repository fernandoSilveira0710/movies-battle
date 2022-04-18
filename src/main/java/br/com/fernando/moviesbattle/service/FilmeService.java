package br.com.fernando.moviesbattle.service;

import org.springframework.stereotype.Service;

import br.com.fernando.moviesbattle.domain.Filme;
import br.com.fernando.moviesbattle.model.Sessao;
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
			filmes[0] = getFilme();
			filmes[1] = getFilme();
		}
		return filmes;
	}

	private Filme[] comparaFilmes(Sessao sessao) {
		Filme[] filmes = new Filme[2];
		while (true) {
			filmes[0] = getFilme();
			do {
				filmes[1] = getFilme();
			} while (filmes[0].getImdbRating().equals(filmes[1].getImdbRating()));
			
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
		return filmes;
	}

	private Filme getFilme() {
		return PesquisaRest.buscaPorId(Const.imdbIds.get(Util.geraNumerosRandom(0, 250)));
	}
}
