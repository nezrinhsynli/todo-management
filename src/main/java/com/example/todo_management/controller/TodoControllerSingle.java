package com.example.todo_management.controller;

import com.example.todo_management.dto.request.TodoRequestDTO;
import com.example.todo_management.dto.response.BaseResponseDTO;
import com.example.todo_management.entities.TodoEntity;
import com.example.todo_management.service.TodoServiceSingle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/single/todo")
public class TodoControllerSingle{

    private final TodoServiceSingle todoService;

    @PostMapping
    public BaseResponseDTO save(@RequestBody TodoRequestDTO todoRequestDTO) {
        return todoService.save(todoRequestDTO);
    }

    @GetMapping
    public TodoEntity getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @GetMapping("/get-all")
    public List<TodoEntity> getAll() {
        return todoService.getAll();
    }

    @PutMapping("/{id}")
    public BaseResponseDTO update(@PathVariable Long id, @RequestBody TodoRequestDTO todoRequestDTO) {
        return todoService.update(id, todoRequestDTO);
    }

    @DeleteMapping("/{id}")
    public BaseResponseDTO delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

}
