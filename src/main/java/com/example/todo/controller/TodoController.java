package com.example.todo.controller;

import com.example.todo.dto.CreateTodoRequest;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

import org.springframework.web.bind.annotation.*;

import java.util.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {
    // private final AtomicLong counter = new AtomicLong();
    private final TodoService todoService = new TodoService();

    @GetMapping
    public Collection<Todo> listTodos() {
        return todoService.listTodos();
    }

    @PostMapping
    public Todo createTodo(@Valid @RequestBody CreateTodoRequest request) {
        return todoService.createTodo(request);
    }

    @PatchMapping("/{id}")
    public Todo completeTodo(@PathVariable int id) {
        try {
            return todoService.completeTodo(id);
        } catch (NoSuchElementException e) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Todo not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable int id) {
        try {
            todoService.deleteTodo(id);
        } catch (NoSuchElementException e) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Todo not found");
        }
    }
}