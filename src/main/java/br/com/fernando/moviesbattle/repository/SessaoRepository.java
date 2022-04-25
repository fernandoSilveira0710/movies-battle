package br.com.fernando.moviesbattle.repository;

import br.com.fernando.moviesbattle.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
