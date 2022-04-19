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
			Gson gson = new Gson();
			Busca busca = gson.fromJson(jsonEmString, Busca.class);
			return busca;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Filme buscaPorId(String id) {
		try {
			String jsonEmString = Connection.conectionForWebService(urlParaChamada + Const.PESQUISA_ID + id);
			Gson gson = new Gson();
			System.err.println(jsonEmString.toString());
			Filme filme = gson.fromJson(jsonEmString, Filme.class);
			return filme;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
