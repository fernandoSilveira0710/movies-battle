package br.com.fernando.moviesbattle.domain;

import br.com.fernando.moviesbattle.model.Sessao;

import javax.persistence.*;

@Entity
@Table(name = "TB_FILMES")
public class Filme {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sessao_id", nullable = false)
    private Sessao sessao;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String imdbID;

    private String imdbRating;

    private String Title;

    public Filme() {
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getTitle() {
        return Title;
    }

    @Override
    public String toString() {
        return "Filme [imdbRating=" + imdbRating + ", imdbID=" + imdbID + ", Title" + Title + "]";
    }

}
