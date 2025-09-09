package com.example.todo.controller;

import com.example.todo.dto.CreateTodoRequest;
import com.example.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
class TodoControllerHttpTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    void createTodo_valid_returnsTodo() throws Exception {
        when(todoService.createTodo(any(CreateTodoRequest.class)))
                .thenReturn(new com.example.todo.model.Todo(1, "Test", "desc", false));

        mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Test\", \"description\": \"desc\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test"));
    }

    @Test
    void createTodo_invalidTitle_returnsBadRequest() throws Exception {
        mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"\", \"description\": \"desc\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.title").exists());
    }

    @Test
    void completeTodo_notFound_returns404() throws Exception {
        when(todoService.completeTodo(999)).thenThrow(new java.util.NoSuchElementException());
        mockMvc.perform(patch("/todos/999"))
                .andExpect(status().isNotFound());
    }
}