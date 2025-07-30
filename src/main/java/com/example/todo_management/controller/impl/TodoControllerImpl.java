package com.example.todo_management.controller.impl;

import com.example.todo_management.controller.IController;
import com.example.todo_management.dto.request.TodoRequest;
import com.example.todo_management.entities.Todo;
import com.example.todo_management.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/todo")
public class TodoControllerImpl implements IController {

    @Autowired
    private ITodoService todoService;

    @PostMapping(path = "/save")
    @Override
    public void save(@RequestBody TodoRequest todoRequest) {
        todoService.save(todoRequest);
    }

    @GetMapping(path = "/get-all")
    @Override
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void delete(@PathVariable Long id){
        todoService.delete(id);
    }

}
