package com.example.todo_management.controller;

import com.example.todo_management.dto.request.TodoRequestDTO;
import com.example.todo_management.dto.response.BaseResponseDTO;
import com.example.todo_management.dao.entity.TodoEntity;
import com.example.todo_management.service.TodoServiceConcurrent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/concurrent/todo")
public class TodoControllerConcurrent {

    private final TodoServiceConcurrent todoService;

    @PostMapping
    public CompletableFuture<BaseResponseDTO> save(@RequestBody TodoRequestDTO todoRequestDTO) {
        return todoService.save(todoRequestDTO);
    }

    @GetMapping
    public CompletableFuture<TodoEntity> getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @GetMapping("/get-all")
    public CompletableFuture<List<TodoEntity>> getAll() {
        return todoService.getAll();
    }

    @PutMapping("/{id}")
    public CompletableFuture<BaseResponseDTO> update(@PathVariable Long id, @RequestBody TodoRequestDTO todoRequestDTO) {
        return todoService.update(id, todoRequestDTO);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<BaseResponseDTO> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

}
