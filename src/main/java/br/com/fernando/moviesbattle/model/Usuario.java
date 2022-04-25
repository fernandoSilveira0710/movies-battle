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

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nick;

	private String senha;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "partida_id", referencedColumnName = "id")
	private Partida partida;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ranking_id", referencedColumnName = "id")
	private Ranking ranking;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Initializes a newly created Usuario object
	 *
	 * @param  nick nome
	 * @param  senha senha
	 * @param  ranking um ranking
	 */
	public Usuario(String nick, String senha, Ranking ranking) {
		super();
		this.nick = nick;
		this.senha = senha;
		this.ranking = ranking;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nick=" + nick + ", senha=" + senha + ", ranking=" + ranking + "]";
	}

}
