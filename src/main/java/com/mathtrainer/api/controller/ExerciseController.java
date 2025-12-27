package com.mathtrainer.api.controller;

import com.mathtrainer.api.dto.ExerciseResponseDTO;
import com.mathtrainer.api.model.Exercise;
import com.mathtrainer.api.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/exercicio")
public class ExerciseController {
    private final ExerciseService service;
    public ExerciseController(ExerciseService service){ this.service = service; }

    @PostMapping("/gerar")
    public ResponseEntity<?> gerar(@RequestBody(required=false) java.util.Map<String,String> body) {
        String tipo = (body==null)?null:body.get("tipo");
        Exercise ex = service.createRandomExercise(tipo);
        ExerciseResponseDTO dto = new ExerciseResponseDTO(ex.getId(), ex.getType().getName(), ex.getStatement(), ex.getCorrectAnswer(), ex.getExplanation());
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/verificar")
    public ResponseEntity<?> verificar(@RequestBody java.util.Map<String,Object> body) {
        try {
            UUID id = UUID.fromString((String) body.get("id"));
            double resposta = Double.parseDouble(body.get("resposta").toString());
            Exercise ex = service.getById(id);
            if (ex==null) return ResponseEntity.badRequest().body(java.util.Map.of("error","Exercício não encontrado"));
            boolean correto = Double.compare(ex.getCorrectAnswer(), resposta)==0;
            return ResponseEntity.ok(java.util.Map.of("correto", correto, "respostaCorreta", ex.getCorrectAnswer(), "explicacao", ex.getExplanation()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(java.util.Map.of("error","Requisição inválida"));
        }
    }
}
