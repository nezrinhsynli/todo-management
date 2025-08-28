package com.example.todo_management.controller.impl;

import com.example.todo_management.controller.ITodoControllerConcurrent;
import com.example.todo_management.dto.request.TodoRequest;
import com.example.todo_management.dto.response.BaseResponse;
import com.example.todo_management.entities.Todo;
import com.example.todo_management.service.ITodoServiceConcurrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "rest/api/concurrent/todo")
public class TodoControllerConcurrentImpl implements ITodoControllerConcurrent {

    @Autowired
    private ITodoServiceConcurrent todoService;

    @PostMapping(path = "/save")
    @Override
    public CompletableFuture<BaseResponse> save(@RequestBody TodoRequest todoRequest) {
        return todoService.save(todoRequest);
    }

    @GetMapping(path = "/get-by-id/{id}")
    @Override
    public CompletableFuture<Todo> getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @GetMapping(path = "/get-all")
    @Override
    public CompletableFuture<List<Todo>> getAll() {
        return todoService.getAll();
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public CompletableFuture<BaseResponse> update(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        return todoService.update(id, todoRequest);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public CompletableFuture<BaseResponse> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

}
