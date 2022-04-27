package br.com.fernando.moviesbattle.dto;

public class Login {
    public String nick;
    public String senha;

    public Login() {
        // TODO Auto-generated constructor stub
    }

    public Login(String nick, String senha) {
        super();
        this.nick = nick;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login [nick=" + nick + ", senha=" + senha + "]";
    }


}
