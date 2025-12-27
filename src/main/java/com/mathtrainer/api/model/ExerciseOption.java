package com.mathtrainer.api.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "exercise_option")
public class ExerciseOption {

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private String text;

    @Column(name = "is_correct")
    private boolean correct;

    // getters e setters
}
