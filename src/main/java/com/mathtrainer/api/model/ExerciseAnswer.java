package com.mathtrainer.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "exercise_answer")
public class ExerciseAnswer {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name="exercise_id", nullable=false)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(name="user_answer", nullable=false)
    private double userAnswer;

    @Column(name="is_correct", nullable=false)
    private boolean correct;

    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public ExerciseAnswer() {}
    public ExerciseAnswer(Exercise exercise, User user, double userAnswer, boolean correct) {
        this.exercise = exercise; this.user = user; this.userAnswer = userAnswer; this.correct = correct;
    }

    // getters/setters
}
