package br.com.fernando.moviesbattle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "TB_RANKING")
public class Ranking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private Integer pontuacao;

	private Integer sequenciaQuiz;

	private Double porcentagemAcerto;

	@JsonIgnore
	@OneToOne(mappedBy = "ranking")
	@JoinColumn(name = "ranking_id", referencedColumnName = "id")
	private Usuario usuario;

	public Ranking() {
		// TODO Auto-generated constructor stub
	}

	public Ranking(Integer pontuacao, Integer sequenciaQuiz, Double porcentagemAcerto) {
		this.pontuacao = pontuacao;
		this.sequenciaQuiz = sequenciaQuiz;
		this.porcentagemAcerto = porcentagemAcerto;
	}

	public Double getPorcentagemAcerto() {
		return porcentagemAcerto;
	}

	public void setPorcentagemAcerto(Double porcentagemAcerto) {
		this.porcentagemAcerto = porcentagemAcerto;
	}

	public Integer getSequenciaQuiz() {
		return sequenciaQuiz;
	}

	public void setSequenciaQuiz(Integer sequenciaQuiz) {
		this.sequenciaQuiz = sequenciaQuiz;
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

	@Override
	public String toString() {
		return "Ranking [id=" + id + ", pontuacao=" + pontuacao + ", sequenciaQuiz=" + sequenciaQuiz
				+ ", porcentagemAcerto=" + porcentagemAcerto + ", usuario=" + usuario + "]";
	}
	
	

}
