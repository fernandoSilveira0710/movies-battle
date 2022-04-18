package br.com.fernando.moviesbattle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SESSAO")
public class Sessao {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String imdbIdFilme1;
	
	private String imdbIdFilme2;
	
	private boolean respondido;
	
	
	public Sessao() {
		// TODO Auto-generated constructor stub
	}
	
	


	public Sessao(String imdbIdFilme1, String imdbIdFilme2, boolean respondido) {
		super();
		this.imdbIdFilme1 = imdbIdFilme1;
		this.imdbIdFilme2 = imdbIdFilme2;
		this.respondido = respondido;
	}

	
	public boolean isRespondido() {
		return respondido;
	}
	
	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getImdbIdFilme1() {
		return imdbIdFilme1;
	}


	public void setImdbIdFilme1(String imdbIdFilme1) {
		this.imdbIdFilme1 = imdbIdFilme1;
	}


	public String getImdbIdFilme2() {
		return imdbIdFilme2;
	}


	public void setImdbIdFilme2(String imdbIdFilme2) {
		this.imdbIdFilme2 = imdbIdFilme2;
	}




	@Override
	public String toString() {
		return "Sessao [id=" + id + ", imdbIdFilme1=" + imdbIdFilme1 + ", imdbIdFilme2=" + imdbIdFilme2
				+ ", respondido=" + respondido + "]";
	}
	
	
	
	
}
