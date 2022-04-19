package br.com.fernando.moviesbattle.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author Fernando Silveira
 *
 * 
 */
@Entity
@Table(name = "TB_PARTIDA")
public class Partida {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer vidas;

	private boolean ativo;

	private int pontos;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sessao_id", referencedColumnName = "id")
	private Sessao sessao;

	@JsonManagedReference
	@OneToOne(mappedBy = "partida")
	private Usuario usuario;

	public Partida() {
		// TODO Auto-generated constructor stub
	}

	public Partida(Integer vidas, boolean ativo, int pontos) {
		super();
		this.vidas = vidas;
		this.ativo = ativo;
		this.pontos = pontos;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getVidas() {
		return vidas;
	}

	public void setVidas(Integer vidas) {
		this.vidas = vidas;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

}
