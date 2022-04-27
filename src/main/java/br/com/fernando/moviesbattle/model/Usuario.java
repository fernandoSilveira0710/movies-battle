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

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "usuario")
	private String user;

	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	private Partida partida;

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
		return "Usuario [id=" + id + ", user=" + user + ", password=" + password + ", ranking=" + ranking.getPontuacao() + ", partida="+partida.getId()+"]";
	}

}
