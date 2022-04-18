
package br.com.fernando.moviesbattle.domain;

import java.util.ArrayList;
import java.util.List;

public class Busca {

    private List<Search> search = new ArrayList<Search>();
    private String totalResults;
    private String response;

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
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
