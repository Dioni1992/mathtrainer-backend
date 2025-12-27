package com.mathtrainer.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name="type_id", nullable=false)
    private ExerciseType type;

    @Column(nullable=false, length=500)
    private String statement;

    @Column(name="correct_answer", nullable=false)
    private double correctAnswer;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Exercise(){}

    public Exercise(ExerciseType type, String statement, double correctAnswer, String explanation){
        this.type = type;
        this.statement = statement;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }

    // getters/setters
    public UUID getId(){return id;}
    public ExerciseType getType(){return type;}
    public void setType(ExerciseType type){this.type = type;}
    public String getStatement(){return statement;}
    public void setStatement(String statement){this.statement = statement;}
    public double getCorrectAnswer(){return correctAnswer;}
    public void setCorrectAnswer(double correctAnswer){this.correctAnswer = correctAnswer;}
    public String getExplanation(){return explanation;}
    public void setExplanation(String explanation){this.explanation = explanation;}
}
