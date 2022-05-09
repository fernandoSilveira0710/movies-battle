package br.com.fernando.moviesbattle.service;

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

	public Filme[] getFilmes(Sessao sessao) {
		Filme[] filmes = new Filme[2];
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
		System.err.println("USUARIO"+usuario.toString());
		try {
				System.err.println("IMDB FILME1: "+usuario.getPartida().getSessao().getImdbIdFilme1());
				System.err.println("IMDB FILME2: "+usuario.getPartida().getSessao().getImdbIdFilme2());
				
				boolean resp = (Double.parseDouble(PesquisaRest.buscaPorId(usuario.getPartida().getSessao().getImdbIdFilme1()).getImdbRating()))
						> (Double.parseDouble(PesquisaRest.buscaPorId(usuario.getPartida().getSessao().getImdbIdFilme2()).getImdbRating()));
				return (resp == resposta.resposta) ? "1" : "2";
			} catch (Exception e) {
				return "3";
			}

	}
}
