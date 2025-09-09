package com.example.todo.repo;

import com.example.todo.model.Todo;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTodoRepository {
    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public Todo save(Todo todo) {
        todos.put(todo.getId(), todo);
        return todo;
    }

    public Todo findById(long id) {
        return todos.get(id);
    }

    public List<Todo> findAll() {
        return todos.values().stream()
                .sorted(Comparator
                        .comparing(Todo::getCompleted)
                        .thenComparing(Todo::getCreatedAt))
                .toList();
    }

    public void deleteById(long id) {
        todos.remove(id);
    }

    public boolean existsById(long id) {
        return todos.containsKey(id);
    }

    public Long getCounter() {
        return counter.get();
    }

    public Long incAndGetCounter() {
        return counter.incrementAndGet();
    }
}