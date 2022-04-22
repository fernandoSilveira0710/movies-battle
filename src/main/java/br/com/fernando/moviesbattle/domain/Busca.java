
package br.com.fernando.moviesbattle.domain;

import java.util.ArrayList;
import java.util.List;

public class Busca {

	private List<Filmes> filmes = new ArrayList<>();
	private String totalResults;
	private String response;

	public List<Filmes> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filmes> filmes) {
		this.filmes = filmes;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
