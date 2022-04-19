package br.com.fernando.moviesbattle.dto;

public class GenericRanking {
	public String nick;
	public Integer pontuacao;
	
	public GenericRanking(String nick, Integer pontuacao) {
		super();
		this.nick = nick;
		this.pontuacao = pontuacao;
	}
	
	public GenericRanking() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getPontuacao() {
		return pontuacao;
	}
	
}
