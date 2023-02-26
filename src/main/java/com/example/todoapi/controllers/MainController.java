package com.example.todoapi.controllers;

import com.example.todoapi.models.Todo;
import com.example.todoapi.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/")
public class MainController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("api/get-all-todo")
    public List<Todo> getAllTodo() {
       return todoRepository.findAll();
    }

    @GetMapping("api/get-todo")
    public List<Todo> getTodo(
            @RequestParam(defaultValue = "false") Boolean state
    ) {
        return todoRepository.getAllByState(state);
    }

    @GetMapping("api/test")
    public String test() {
        return "success";
    }

    @PostMapping("api/add-todo")
    public boolean addTodo(
            @RequestParam String title,
            @RequestParam(required = false) String description
    ) {
        description = description == null? "" : description;
        todoRepository.save(new Todo(title, description, false));
        return true;
    }

    @PostMapping("api/delete-todo")
    public boolean deleteTodo(
            @RequestParam Integer id
    ) {
        todoRepository.deleteById(id);
        return true;
    }

    @PostMapping("api/mark-as-done")
    public boolean markAsDoneTodo(
            @RequestParam Integer id
    ) {
        Todo todo = todoRepository.getReferenceById(id);
        todo.setState(true);
        todoRepository.save(todo);
        return true;
    }
}
