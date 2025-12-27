package com.mathtrainer.api.repository;

import com.mathtrainer.api.model.User;
import com.mathtrainer.api.model.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserStatsRepository extends JpaRepository<UserStats, UUID> {
    Optional<UserStats> findByUser(User user);
}
