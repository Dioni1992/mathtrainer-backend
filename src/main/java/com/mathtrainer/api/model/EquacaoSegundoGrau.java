package com.mathtrainer.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("segundo_grau")
public class EquacaoSegundoGrau extends Equacao {

    private final double a, b, c;
    private final double raiz1, raiz2;
    private final String enunciado;

    public EquacaoSegundoGrau() {
        // exemplo simples (pode alterar para aleatório se quiser)
        this.a = 1;
        this.b = -5;
        this.c = 6;
        double delta = b * b - 4 * a * c;
        double sqrt = Math.sqrt(Math.max(0, delta));
        this.raiz1 = (-b + sqrt) / (2 * a);
        this.raiz2 = (-b - sqrt) / (2 * a);
        this.enunciado = "x² - 5x + 6 = 0";
    }

    public EquacaoSegundoGrau(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
        double delta = b * b - 4 * a * c;
        double sqrt = Math.sqrt(Math.max(0, delta));
        this.raiz1 = (-b + sqrt) / (2 * a);
        this.raiz2 = (-b - sqrt) / (2 * a);
        this.enunciado = String.format("%sx² + %sx + %s = 0", formatNumber(a), formatNumber(b), formatNumber(c));
    }

    @Override
    public String getEnunciado() {
        return enunciado;
    }

    @Override
    public double getRespostaCorreta() {
        return raiz1;
    }


    public String getExplicacao(double respostaUsuario) {
        double delta = b*b - 4*a*c;
        return String.format("Bhaskara: Δ = %.1f → raízes: %s e %s. Você respondeu: %s",
                delta, formatNumber(raiz1), formatNumber(raiz2), formatNumber(respostaUsuario));
    }

    @Override
    public boolean verificarResposta(double tentativa) {
        double eps = 1e-6;
        return Math.abs(tentativa - raiz1) <= Math.max(eps, Math.abs(raiz1) * 1e-6)
                || Math.abs(tentativa - raiz2) <= Math.max(eps, Math.abs(raiz2) * 1e-6);
    }

    private String formatNumber(double v) {
        if (v == Math.rint(v)) return String.format("%.0f", v);
        return String.valueOf(v);
    }
}
