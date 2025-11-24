package com.mathtrainer.api.service;

import com.mathtrainer.api.model.Equacao;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ExerciseService {

    private final GeradorEquacoes gerador = new GeradorEquacoes();
    private final Map<UUID, Equacao> store = new ConcurrentHashMap<>();

    public UUID createExercise(String tipo) {
        Equacao eq = (tipo == null || tipo.isBlank())
                ? gerador.gerarEquacaoAleatoria()
                : gerador.gerarEquacaoPorTipo(tipo);

        UUID id = UUID.randomUUID();
        store.put(id, eq);
        return id;
    }

    public Equacao getExercise(UUID id) {
        return store.get(id);
    }

    public VerifyResult verify(UUID id, double respostaUsuario) {
        Equacao eq = store.get(id);
        if (eq == null) return null;

        boolean correto = eq.verificarResposta(respostaUsuario);
        String explicacao = eq.getExplicacao(respostaUsuario);
        double respostaCorreta = eq.getRespostaCorreta();

        return new VerifyResult(correto, respostaCorreta, explicacao);
    }

    public boolean remove(UUID id) {
        return store.remove(id) != null;
    }

    public List<UUID> listActive() {
        return new ArrayList<>(store.keySet());
    }

    public static class VerifyResult {
        public final boolean correto;
        public final double respostaCorreta;
        public final String explicacao;

        public VerifyResult(boolean correto, double respostaCorreta, String explicacao) {
            this.correto = correto;
            this.respostaCorreta = respostaCorreta;
            this.explicacao = explicacao;
        }
    }
}
