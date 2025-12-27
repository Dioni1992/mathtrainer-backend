package com.mathtrainer.api.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_stats")
public class UserStats {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int acertosHoje = 0;
    private int acertosSemana = 0;
    private int acertosMes = 0;
    private int streakDias = 0;

    public UserStats() {}

    // ---------- GETTERS E SETTERS ----------

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAcertosHoje() {
        return acertosHoje;
    }

    public void setAcertosHoje(int acertosHoje) {
        this.acertosHoje = acertosHoje;
    }

    public int getAcertosSemana() {
        return acertosSemana;
    }

    public void setAcertosSemana(int acertosSemana) {
        this.acertosSemana = acertosSemana;
    }

    public int getAcertosMes() {
        return acertosMes;
    }

    public void setAcertosMes(int acertosMes) {
        this.acertosMes = acertosMes;
    }

    public int getStreakDias() {
        return streakDias;
    }

    public void setStreakDias(int streakDias) {
        this.streakDias = streakDias;
    }
}
