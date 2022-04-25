package br.com.fernando.moviesbattle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String user;

	private String password;

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
	 * @param  user - nome
	 * @param  password - senha
	 * @param  ranking - um ranking
	 */
	public Usuario(String user, String password, Ranking ranking) {
		super();
		this.user = user;
		this.password = password;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", user=" + user + ", password=" + password + ", ranking=" + ranking + "]";
	}

}
