package com.mathtrainer.api.service;

import com.mathtrainer.api.model.*;
import com.mathtrainer.api.repository.ExerciseRepository;
import com.mathtrainer.api.repository.ExerciseTypeRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepo;
    private final ExerciseTypeRepository typeRepo;
    private final GeradorEquacoes gerador = new GeradorEquacoes();

    public ExerciseService(ExerciseRepository exerciseRepo, ExerciseTypeRepository typeRepo){
        this.exerciseRepo = exerciseRepo; this.typeRepo = typeRepo;
    }

    public Exercise createRandomExercise(String tipoKey) {
        // If tipoKey provided, try find type; else pick default
        ExerciseType type = null;
        if (tipoKey != null) type = typeRepo.findAll().stream().filter(t->t.getName().equalsIgnoreCase(tipoKey)).findFirst().orElse(null);
        // generate using gerador (you already have GeradorEquacoes producing subclassless Equacao earlier — adapt)
        // We'll create a simple exercise instance with the gerador helper returning an Exercise-like data
        com.mathtrainer.api.model.Equacao eqPojo = gerador.gerarEquacaoPorTipo(tipoKey==null?"simples":tipoKey);
        // Map to Exercise entity
        ExerciseType chosenType = (type != null) ? type : typeRepo.findAll().stream().findFirst().orElse(null);
        Exercise ex = new Exercise(chosenType, eqPojo.getEnunciado(), eqPojo.getRespostaCorreta(), eqPojo.getExplicacao());
        return exerciseRepo.save(ex);
    }

    public Exercise getById(UUID id){ return exerciseRepo.findById(id).orElse(null); }
}
