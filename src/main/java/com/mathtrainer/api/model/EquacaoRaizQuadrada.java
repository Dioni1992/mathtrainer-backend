package com.mathtrainer.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Random;

@Entity
@DiscriminatorValue("raiz_quadrada")
public class EquacaoRaizQuadrada extends Equacao {

    // Interpretamos enunciado como "√x = r" -> resposta = r^2
    private final double r;
    private final double resposta;
    private final String enunciado;

    public EquacaoRaizQuadrada() {
        Random rand = new Random();
        this.r = rand.nextInt(9) + 1; // 1..9
        this.resposta = r * r;
        this.enunciado = String.format("√x = %.0f", r);
    }

    public EquacaoRaizQuadrada(double r) {
        this.r = r;
        this.resposta = r * r;
        this.enunciado = String.format("√x = %s", formatNumber(r));
    }

    @Override
    public String getEnunciado() {
        return enunciado;
    }

    @Override
    public double getRespostaCorreta() {
        return resposta;
    }


    public String getExplicacao(double respostaUsuario) {
        return String.format("Eleve ambos os lados ao quadrado: x = %s", formatNumber(resposta));
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
