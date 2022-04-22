package br.com.fernando.moviesbattle.domain;

import br.com.fernando.moviesbattle.model.Sessao;

import javax.persistence.*;

@Entity
@Table(name = "TB_FILMES")
public class Filme {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sessao_id", nullable = false)
	private Sessao sessao;

	private String imdbRating;
	private String imdbVotes;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String imdbID;


	private String Title;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sessao_id_id")
	private Sessao sessaoId;

	public Sessao getSessaoId() {
		return sessaoId;
	}

	public void setSessaoId(Sessao sessaoId) {
		this.sessaoId = sessaoId;
	}

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
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Filme [imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes + ", imdbID=" + imdbID + "]";
	}
	
	

}
