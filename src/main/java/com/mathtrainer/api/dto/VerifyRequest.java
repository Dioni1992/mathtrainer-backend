package com.mathtrainer.api.dto;

public class VerifyRequest {
    private String id;
    private double resposta;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getResposta() { return resposta; }
    public void setResposta(double resposta) { this.resposta = resposta; }
}
