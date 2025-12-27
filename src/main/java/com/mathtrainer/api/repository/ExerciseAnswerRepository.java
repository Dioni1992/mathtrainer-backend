package com.mathtrainer.api.repository;

import com.mathtrainer.api.model.ExerciseAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ExerciseAnswerRepository extends JpaRepository<ExerciseAnswer, UUID> {
    List<ExerciseAnswer> findByUserId(UUID userId);
}
