package com.mathtrainer.api.service;

import com.mathtrainer.api.model.*;
import java.util.Random;

public class GeradorEquacoes {

    private final Random random = new Random();

    public Equacao gerarEquacaoAleatoria() {
        int tipo = random.nextInt(5);
        return switch (tipo) {
            case 0 -> new EquacaoPrimeiroGrauSimples();
            case 1 -> new EquacaoPrimeiroGrauMedio();
            case 2 -> new EquacaoSegundoGrau();
            case 3 -> new EquacaoFracao();
            case 4 -> new EquacaoRaizQuadrada();
            default -> new EquacaoPrimeiroGrauSimples();
        };
    }

    public Equacao gerarEquacaoPorTipo(String tipo) {
        if (tipo == null) tipo = "";
        return switch (tipo.toLowerCase()) {
            case "simples", "p1" -> new EquacaoPrimeiroGrauSimples();
            case "media", "p2" -> new EquacaoPrimeiroGrauMedio();
            case "segundo", "segundo_grau", "quadratica" -> new EquacaoSegundoGrau();
            case "fracao" -> new EquacaoFracao();
            case "raiz", "raiz_quadrada" -> new EquacaoRaizQuadrada();
            default -> throw new IllegalArgumentException("Tipo inválido. Use: simples, media, segundo, fracao, raiz");
        };
    }
}
