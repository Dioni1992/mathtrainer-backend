package com.mathtrainer.api.repository;

import com.mathtrainer.api.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {}
