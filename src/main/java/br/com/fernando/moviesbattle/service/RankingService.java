package br.com.fernando.moviesbattle.service;

import br.com.fernando.moviesbattle.dto.GenericRanking;
import br.com.fernando.moviesbattle.model.Ranking;
import br.com.fernando.moviesbattle.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingService {

    @Autowired(required = true)
    RankingRepository repository;

    public List<Ranking> findAll() {
        return repository.findAll();
    }

    public void create(Ranking ranking) {
        repository.save(ranking);
    }

    public List<GenericRanking> sortList(List<Ranking> list) {
        List<GenericRanking> rankings = new ArrayList<>();
        for (Ranking ranking : list) {
            rankings.add(new GenericRanking(ranking.getUsuario().getUser(), ranking.getPontuacao()));
        }
        return rankings;
    }

}
