package com.example.todoapi.repositories;

import com.example.todoapi.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> getAllByState(Boolean state);

}
