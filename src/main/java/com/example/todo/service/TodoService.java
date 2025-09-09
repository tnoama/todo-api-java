package com.example.todo.service;

import com.example.todo.dto.CreateTodoRequest;
import com.example.todo.model.Todo;
import com.example.todo.repo.InMemoryTodoRepository;

import java.time.Instant;
import java.util.Collection;
import java.util.NoSuchElementException;

public class TodoService {
    private final InMemoryTodoRepository todoRepository = new InMemoryTodoRepository();

    public Collection<Todo> listTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(CreateTodoRequest request) {
        long id = todoRepository.incAndGetCounter();
        Todo todo = new Todo(id, request.getTitle(), request.getDescription(), false);
        // createdAt is set in the Todo constructor
        todo.setCreatedAt(Instant.now());
        todoRepository.save(todo);
        return todo;
    }

    public Todo completeTodo(long id) {
        Todo todo = todoRepository.findById(id);
        if (todo == null) {
            throw new NoSuchElementException("Todo not found");
        }
        todo.setCompleted(true);
        // Do not update createdAt here; it should remain the creation time
        todoRepository.save(todo);
        return todo;
    }

    public void deleteTodo(long id) {
        Todo todo = todoRepository.findById(id);
        if (todo == null) {
            throw new NoSuchElementException("Todo not found");
        }
        todoRepository.deleteById(id);
    }
}