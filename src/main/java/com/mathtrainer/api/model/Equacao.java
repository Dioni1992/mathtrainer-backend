package com.mathtrainer.api.model;

public abstract class Equacao {

    // enunciado legível para front
    public abstract String getEnunciado();

    // resposta correta como double
    public abstract double getRespostaCorreta();

    // explicação que pode usar a resposta do usuário
    public abstract String getExplicacao(double respostaUsuario);

    // checa a tentativa (double) com tolerância relativa
    public boolean verificarResposta(double tentativa) {
        double esperado = getRespostaCorreta();
        double eps = 1e-6; // tolerância pequena (ajustável)
        return Math.abs(tentativa - esperado) <= Math.max(eps, Math.abs(esperado) * 1e-6);
    }
}
