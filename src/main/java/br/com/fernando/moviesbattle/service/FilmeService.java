package br.com.fernando.moviesbattle.service;

import br.com.fernando.moviesbattle.domain.Filme;
import br.com.fernando.moviesbattle.dto.Resposta;
import br.com.fernando.moviesbattle.model.Sessao;
import br.com.fernando.moviesbattle.model.Usuario;
import br.com.fernando.moviesbattle.rest.PesquisaRest;
import br.com.fernando.moviesbattle.utils.Const;
import br.com.fernando.moviesbattle.utils.Util;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        if (filmes.size() == usuario.getPartida().getSessao().getTamanho()) {
            try {
                boolean resp = Double.parseDouble(filmes.get(0).getImdbRating()) > Double.parseDouble(filmes.get(1).getImdbRating());
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
