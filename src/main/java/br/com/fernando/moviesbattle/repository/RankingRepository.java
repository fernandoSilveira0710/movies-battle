package br.com.fernando.moviesbattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fernando.moviesbattle.model.Ranking;

@Repository
public interface RankingRepository  extends JpaRepository<Ranking, Long>{

}
