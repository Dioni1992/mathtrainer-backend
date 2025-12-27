package com.mathtrainer.api.repository;

import com.mathtrainer.api.model.Ranking;
import com.mathtrainer.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface RankingRepository extends JpaRepository<Ranking, UUID> {

    Optional<Ranking> findByUserAndDataAndTipo(User user, LocalDate data, String tipo);
}
