package com.example.todo_management.controller;

import com.example.todo_management.dto.request.TodoRequest;
import com.example.todo_management.dto.response.BaseResponse;
import com.example.todo_management.entities.Todo;

import java.util.List;

public interface IController {

    BaseResponse save(TodoRequest todoRequest);

    Todo getById(Long id);

    List<Todo> getAll();

    BaseResponse update(Long id, TodoRequest todoRequest);

    BaseResponse delete(Long id);

}
