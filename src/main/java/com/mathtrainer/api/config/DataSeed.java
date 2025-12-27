package com.mathtrainer.api.config;

import com.mathtrainer.api.model.ExerciseType;
import com.mathtrainer.api.repository.ExerciseTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeed implements CommandLineRunner {

    private final ExerciseTypeRepository typeRepo;

    public DataSeed(ExerciseTypeRepository typeRepo) { this.typeRepo = typeRepo; }

    @Override
    public void run(String... args) throws Exception {
        String[] nomes = {"primeiro_simples","primeiro_medio","segundo_grau","fracao","raiz_quadrada"};
        for(String n: nomes){
            if (typeRepo.findByName(n).isEmpty()) {
                typeRepo.save(new ExerciseType(n, "Tipo automático: " + n));
            }
        }
    }
}
