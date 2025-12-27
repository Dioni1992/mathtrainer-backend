package com.mathtrainer.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Random;

@Entity
@DiscriminatorValue("primeiro_simples")
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

        // Preenche a entidade Equacao corretamente
        super.setTipo("primeiro_simples");
        super.setEnunciado(this.enunciado);
        super.setRespostaCorreta(this.resposta);
        super.setExplicacao(getExplicacao());
    }

    @Override
    public String getExplicacao() {
        return String.format(
                "Isolando x: %.0fx = %.0f → x = %s",
                a, -b, formatNumber(resposta)
        );
    }

    private String formatNumber(double v) {
        if (v == Math.rint(v)) return String.format("%.0f", v);
        return String.valueOf(v);
    }
}
