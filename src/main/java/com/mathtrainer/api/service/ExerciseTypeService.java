package com.mathtrainer.api.service;

import com.mathtrainer.api.model.ExerciseType;
import com.mathtrainer.api.repository.ExerciseTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseTypeService {

    private final ExerciseTypeRepository repo;

    public ExerciseTypeService(ExerciseTypeRepository repo) {
        this.repo = repo;
    }

    public List<ExerciseType> findAll() {
        return repo.findAll();
    }

    public ExerciseType save(ExerciseType type) {
        return repo.save(type);
    }
}
