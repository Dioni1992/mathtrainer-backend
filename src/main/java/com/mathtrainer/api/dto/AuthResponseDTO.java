package com.mathtrainer.api.dto;
import java.util.UUID;
public class AuthResponseDTO {
    public String token;
    public UUID id;
    public String nome;
    public String email;
    public AuthResponseDTO(String token, UUID id, String nome, String email) {
        this.token=token;
        this.id=id;
        this.nome=nome;
        this.email=email;
    }
}
