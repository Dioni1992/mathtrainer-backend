package com.mathtrainer.api.service;

import com.mathtrainer.api.model.Ranking;
import com.mathtrainer.api.model.User;
import com.mathtrainer.api.repository.RankingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RankingService {

    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public Ranking adicionarPontos(User user, int pontos, String tipo) {

        Ranking ranking = rankingRepository
                .findByUserAndDataAndTipo(user, LocalDate.now(), tipo)
                .orElseGet(() -> {
                    Ranking novo = new Ranking();
                    novo.setUser(user);
                    novo.setTipo(tipo);
                    novo.setData(LocalDate.now());
                    novo.setPontos(0);
                    return novo;
                });

        ranking.setPontos(ranking.getPontos() + pontos);

        return rankingRepository.save(ranking);
    }
}
