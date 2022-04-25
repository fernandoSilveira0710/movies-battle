
package br.com.fernando.moviesbattle.domain;

public class Filme {

	private String imdbRating;
	private String imdbID;
	private String Title;

	public String getImdbRating() {
		return imdbRating;
	}

	public String getImdbID() {
		return imdbID;
	}

	public String getTitle() {
		return Title;
	}

	public Filme() {
	}

	@Override
	public String toString() {
		return "Filme [imdbRating=" + imdbRating + ", imdbID=" + imdbID + ", Title" + Title +"]";
	}

}
