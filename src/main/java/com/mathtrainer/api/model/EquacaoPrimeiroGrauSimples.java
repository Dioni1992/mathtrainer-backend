package com.mathtrainer.api.model;

import java.util.Random;

public class EquacaoPrimeiroGrauSimples extends Equacao {

    private final double a, b;
    private final double resposta;
    private final String enunciado;

    public EquacaoPrimeiroGrauSimples() {
        Random r = new Random();
        this.a = r.nextInt(9) + 1;        // 1..9
        this.b = r.nextInt(41) - 20;      // -20..20
        this.resposta = -b / a;
        this.enunciado = String.format("%.0fx + %.0f = 0", a, b);
    }

    public EquacaoPrimeiroGrauSimples(double a, double b) {
        this.a = a;
        this.b = b;
        this.resposta = -b / a;
        this.enunciado = String.format("%sx + %s = 0", formatNumber(a), formatNumber(b));
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
        return String.format("Isolando x: %.0fx = %.0f → x = %s", a, -b, formatNumber(resposta));
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
