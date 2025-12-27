package com.mathtrainer.api.service;

import com.mathtrainer.api.model.User;
import com.mathtrainer.api.model.UserStats;
import com.mathtrainer.api.repository.UserStatsRepository;
import org.springframework.stereotype.Service;

@Service
public class UserStatsService {

    private final UserStatsRepository repo;

    public UserStatsService(UserStatsRepository repo) {
        this.repo = repo;
    }

    public UserStats getOrCreate(User user) {
        return repo.findByUser(user).orElseGet(() -> {
            var stats = new UserStats();
            stats.setUser(user);
            stats.setAcertosHoje(0);
            stats.setAcertosSemana(0);
            stats.setAcertosMes(0);
            stats.setStreakDias(0);
            return repo.save(stats);
        });
    }

    public UserStats save(UserStats stats) {
        return repo.save(stats);
    }
}
