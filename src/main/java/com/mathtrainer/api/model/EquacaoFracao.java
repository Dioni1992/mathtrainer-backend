package com.mathtrainer.api.model;

import java.util.Random;

public class EquacaoFracao extends Equacao {

    private final double a, b;
    private final double resposta;
    private final String enunciado;

    public EquacaoFracao() {
        Random r = new Random();
        this.a = r.nextInt(8) + 2;       // 2..9
        this.b = r.nextInt(21) - 10;     // -10..10
        this.resposta = -b / a;
        this.enunciado = String.format("(%sx + %s) / %s = 0", formatNumber(a), formatNumber(b), formatNumber(a));
    }

    public EquacaoFracao(double a, double b) {
        this.a = a; this.b = b;
        this.resposta = -b / a;
        this.enunciado = String.format("(%s x + %s) / %s = 0", formatNumber(a), formatNumber(b), formatNumber(a));
    }

    @Override
    public String getEnunciado() {
        return enunciado;
    }

    @Override
    public double getRespostaCorreta() {
        return resposta;
    }

    @Override
    public String getExplicacao(double respostaUsuario) {
        return String.format("Multiplique ambos os lados por %s: %s x + %s = 0 → x = %s", formatNumber(a), formatNumber(a), formatNumber(b), formatNumber(resposta));
    }

    @Override
    public boolean verificarResposta(double tentativa) {
        return super.verificarResposta(tentativa);
    }

    private String formatNumber(double v) {
        if (v == Math.rint(v)) return String.format("%.0f", v);
        return String.valueOf(v);
    }
}
