package com.mathtrainer.api.repository;

import com.mathtrainer.api.model.ExerciseOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseOptionRepository extends JpaRepository<ExerciseOption, String> {

    List<ExerciseOption> findByExerciseId(String exerciseId);
}

