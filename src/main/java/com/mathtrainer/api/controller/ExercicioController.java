package com.mathtrainer.api.controller;

import com.mathtrainer.api.dto.GerarRequest;
import com.mathtrainer.api.dto.VerifyRequest;
import com.mathtrainer.api.model.Equacao;
import com.mathtrainer.api.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {

    private final ExerciseService service;

    public ExercicioController(ExerciseService service) {
        this.service = service;
    }

    @PostMapping("/gerar")
    public ResponseEntity<?> gerar(@RequestBody GerarRequest req) {
        try {
            UUID id = service.createExercise(req.getTipo());
            Equacao eq = service.getExercise(id);

            return ResponseEntity.ok(Map.of(
                    "id", id.toString(),
                    "enunciado", eq.getEnunciado()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Erro ao gerar exercício"));
        }
    }

    @PostMapping("/verificar")
    public ResponseEntity<?> verificar(@RequestBody VerifyRequest req) {
        try {
            UUID id = UUID.fromString(req.getId());
            ExerciseService.VerifyResult res = service.verify(id, req.getResposta());

            if (res == null) return ResponseEntity.badRequest().body(Map.of("error", "ID não encontrado"));

            return ResponseEntity.ok(Map.of(
                    "correto", res.correto,
                    "respostaCorreta", res.respostaCorreta,
                    "explicacao", res.explicacao
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "ID inválido"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Erro ao verificar resposta"));
        }
    }
}
