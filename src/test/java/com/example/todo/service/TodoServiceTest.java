package com.example.todo.service;

import com.example.todo.dto.CreateTodoRequest;
import com.example.todo.model.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {
    private final TodoService service = new TodoService();

    @Test
    void createTodo_setsCreatedAtAndCompletedFalse() {
        CreateTodoRequest req = new CreateTodoRequest();
        req.setTitle("Test");
        req.setDescription("desc");
        Todo todo = service.createTodo(req);
        assertNotNull(todo.getCreatedAt());
        assertFalse(todo.getCompleted());
    }

    @Test
    void completeTodo_setsCompletedTrue() {
        CreateTodoRequest req = new CreateTodoRequest();
        req.setTitle("Test");
        req.setDescription("desc");
        Todo todo = service.createTodo(req);
        Todo completed = service.completeTodo(todo.getId());
        assertTrue(completed.getCompleted());
    }

    @Test
    void completeTodo_invalidId_throwsException() {
        assertThrows(Exception.class, () -> service.completeTodo(999));
    }
}