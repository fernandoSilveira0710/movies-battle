package br.com.fernando.moviesbattle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TB_RANKING")
public class Ranking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private Integer pontuacao;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "ranking")
	private Usuario usuario;

	public Ranking() {
		// TODO Auto-generated constructor stub
	}

	public Ranking(Integer pontuacao) {
		super();
		this.pontuacao = pontuacao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

}
