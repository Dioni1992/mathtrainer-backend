package com.mathtrainer.api.repository;

import com.mathtrainer.api.model.UserProgress;
import com.mathtrainer.api.model.User;
import com.mathtrainer.api.model.ExerciseType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserProgressRepository extends JpaRepository<UserProgress, UUID> {
    Optional<UserProgress> findByUserAndType(User user, ExerciseType type);
}
