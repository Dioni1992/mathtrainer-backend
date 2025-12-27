package com.mathtrainer.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "exercise_type")
public class ExerciseType {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable=false, unique=true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public ExerciseType() {}
    public ExerciseType(String name, String description) { this.name=name; this.description=description; }

    // getters/setters
    public UUID getId(){return id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    public LocalDateTime getCreatedAt(){return createdAt;}
}
