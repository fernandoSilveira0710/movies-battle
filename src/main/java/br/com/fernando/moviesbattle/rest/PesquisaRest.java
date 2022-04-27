package br.com.fernando.moviesbattle.rest;

import br.com.fernando.moviesbattle.domain.Busca;
import br.com.fernando.moviesbattle.domain.Filme;
import br.com.fernando.moviesbattle.utils.Connection;
import br.com.fernando.moviesbattle.utils.Const;
import com.google.gson.Gson;

public class PesquisaRest {

    static String urlParaChamada = Const.WEBSERVICE + Const.KEY_ACCESS;

    private static Object getBusca(String item, Class<?> classe) {
        try {
            String jsonEmString = Connection.conectionForWebService(urlParaChamada + item);
            return new Gson().fromJson(jsonEmString, classe);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Busca buscaPorFilme(String nomeFilme) {
        return (Busca) getBusca(Const.PESQUISA + nomeFilme, Busca.class);
    }


    public static Filme buscaPorId(String id) {
        return (Filme) getBusca(Const.PESQUISA_ID + id, Filme.class);
    }
}
