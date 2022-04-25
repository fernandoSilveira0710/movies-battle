package br.com.fernando.moviesbattle.rest;

import com.google.gson.Gson;

import br.com.fernando.moviesbattle.domain.Busca;
import br.com.fernando.moviesbattle.domain.Filme;
import br.com.fernando.moviesbattle.utils.Connection;
import br.com.fernando.moviesbattle.utils.Const;

public class PesquisaRest {

	static String urlParaChamada = Const.WEBSERVICE + Const.KEY_ACCESS;

	public static Busca buscaPorFilme(String nomeFilme) {
		try {
			String jsonEmString = Connection.conectionForWebService(urlParaChamada + Const.PESQUISA + nomeFilme);
			return new Gson().fromJson(jsonEmString, Busca.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Filme buscaPorId(String id) {
		try {
			String jsonEmString = Connection.conectionForWebService(urlParaChamada + Const.PESQUISA_ID + id);
			System.err.println(jsonEmString);
			return new Gson().fromJson(jsonEmString, Filme.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
