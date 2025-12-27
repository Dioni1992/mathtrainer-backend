package com.mathtrainer.api.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "equacoes")
public class Equacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String tipo;
    private String enunciado;
    private double respostaCorreta;
    private String explicacao;

    public Equacao() {}

    public Equacao(String tipo, String enunciado, double respostaCorreta, String explicacao) {
        this.tipo = tipo;
        this.enunciado = enunciado;
        this.respostaCorreta = respostaCorreta;
        this.explicacao = explicacao;
    }

    // Getters e Setters
    public UUID getId() {

        return id;
    }
    public void setId(UUID id)
    { this.id = id;
    }

    public String getTipo()
    { return tipo;
    }
    public void setTipo(String tipo)
    { this.tipo = tipo;
    }

    public String getEnunciado()
    { return enunciado;
    }
    public void setEnunciado(String enunciado)
    { this.enunciado = enunciado;
    }

    public double getRespostaCorreta()
    { return respostaCorreta;
    }
    public void setRespostaCorreta(double respostaCorreta)
    { this.respostaCorreta = respostaCorreta;
    }

    public String getExplicacao()
    { return explicacao;
    }
    public void setExplicacao(String explicacao)
    { this.explicacao = explicacao;
    }

    public boolean verificarResposta(double respostaUsuario)
    {
        return Double.compare(respostaUsuario, respostaCorreta) == 0;
    }

}
