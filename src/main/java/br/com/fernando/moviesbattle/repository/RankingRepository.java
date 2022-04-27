package br.com.fernando.moviesbattle.repository;

import br.com.fernando.moviesbattle.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long> {

}
