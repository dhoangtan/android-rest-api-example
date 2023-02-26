package com.example.todoapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column
    private Boolean state;

    public Todo() {}

    public Todo(String title, String description, Boolean state) {
        this.title = title;
        this.description = description;
        this.state = state;
    }
}
