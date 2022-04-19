
package br.com.fernando.moviesbattle.domain;

public class Filme {

	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String Title;


	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public Filme() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Filme [imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes + ", imdbID=" + imdbID + "]";
	}
	
	

}
