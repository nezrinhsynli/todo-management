package com.example.todo_management.controller.impl;

import com.example.todo_management.controller.ITodoControllerSingle;
import com.example.todo_management.dto.request.TodoRequest;
import com.example.todo_management.dto.response.BaseResponse;
import com.example.todo_management.entities.Todo;
import com.example.todo_management.service.ITodoServiceSingle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/single/todo")
public class TodoControllerSingleImpl implements ITodoControllerSingle {

    @Autowired
    private ITodoServiceSingle todoService;

    @PostMapping(path = "/save")
    @Override
    public BaseResponse save(@RequestBody TodoRequest todoRequest) {
        return todoService.save(todoRequest);
    }

    @GetMapping(path = "/get-by-id/{id}")
    @Override
    public Todo getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @GetMapping(path = "/get-all")
    @Override
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public BaseResponse update(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        return todoService.update(id, todoRequest);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public BaseResponse delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

}
