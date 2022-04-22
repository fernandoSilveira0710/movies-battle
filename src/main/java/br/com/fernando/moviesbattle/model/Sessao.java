package br.com.fernando.moviesbattle.model;

import br.com.fernando.moviesbattle.domain.Filme;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_SESSAO")
public class Sessao {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "sessao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Filme> imdbIdFilmes;

	private Integer tamanho;

	private boolean resposta;

	public Sessao() {
		// TODO Auto-generated constructor stub
	}

	public Sessao(List<Filme> imdbIdFilmes, boolean resposta, Integer tamanho) {
		super();
		this.imdbIdFilmes = imdbIdFilmes;
		this.resposta = resposta;
		this.tamanho = tamanho;
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(Boolean resposta) {
		this.resposta = resposta;
	}

	public Long getId() {
		return id;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public List<Filme> getImdbIdFilmes() {
		return imdbIdFilmes;
	}

	public void setImdbIdFilmes(List<Filme> imdbIdFilmes) {
		this.imdbIdFilmes = imdbIdFilmes;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return "Sessao [id=" + id + ", imdbIdFilmes=" + imdbIdFilmes.toString() + ", resposta=" + resposta + "]";
	}

}
