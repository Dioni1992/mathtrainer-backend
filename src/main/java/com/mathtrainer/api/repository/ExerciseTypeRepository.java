package com.mathtrainer.api.repository;

import com.mathtrainer.api.model.ExerciseType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, UUID> {
    Optional<ExerciseType> findByName(String name);
}
