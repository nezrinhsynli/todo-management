package com.example.todo_management.controller;

import com.example.todo_management.dto.request.TodoRequest;
import com.example.todo_management.entities.Todo;

import java.util.List;

public interface IController {

    void save(TodoRequest todoRequest);

    List<Todo> getAll();

    void delete(Long id);

}
