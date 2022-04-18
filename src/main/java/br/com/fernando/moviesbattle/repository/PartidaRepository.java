package br.com.fernando.moviesbattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fernando.moviesbattle.model.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long>{
}
