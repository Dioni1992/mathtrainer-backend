package com.mathtrainer.api.dto;
import java.util.UUID;
public class ExerciseResponseDTO {
    public UUID id;
    public String tipo;
    public String enunciado;
    public double respostaCorreta;
    public String explicacao;
    public ExerciseResponseDTO(UUID id, String tipo, String enunciado, double respostaCorreta, String explicacao){
        this.id=id;this.tipo=tipo;
        this.enunciado=enunciado;
        this.respostaCorreta=respostaCorreta;
        this.explicacao=explicacao;
    }
}
