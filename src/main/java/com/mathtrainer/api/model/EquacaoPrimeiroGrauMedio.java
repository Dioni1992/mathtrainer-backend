package com.mathtrainer.api.model;

import java.util.Random;

public class EquacaoPrimeiroGrauMedio extends Equacao {

    private final double a, b, c;
    private final double resposta;
    private final String enunciado;

    public EquacaoPrimeiroGrauMedio() {
        Random r = new Random();
        this.a = r.nextInt(9) + 1;      // 1..9
        this.b = r.nextInt(41) - 20;    // -20..20
        this.c = r.nextInt(41) - 20;    // -20..20
        this.resposta = (c - b) / a;
        this.enunciado = String.format("%.0fx + %.0f = %.0f", a, b, c);
    }

    public EquacaoPrimeiroGrauMedio(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
        this.resposta = (c - b) / a;
        this.enunciado = String.format("%sx + %s = %s", formatNumber(a), formatNumber(b), formatNumber(c));
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
        return String.format("Passe %.0f para o outro lado: %.0fx = %.0f → x = %s", b, a, (c - b), formatNumber(resposta));
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
