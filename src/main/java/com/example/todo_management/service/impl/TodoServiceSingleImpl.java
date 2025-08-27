package com.example.todo_management.service.impl;

import com.example.todo_management.dto.request.TodoRequest;
import com.example.todo_management.dto.response.BaseResponse;
import com.example.todo_management.entities.Todo;
import com.example.todo_management.enums.ErrorCodeEnum;
import com.example.todo_management.exception.TodoNotFoundException;
import com.example.todo_management.repository.TodoRepository;
import com.example.todo_management.service.ITodoServiceSingle;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceSingleImpl implements ITodoServiceSingle {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public BaseResponse save(TodoRequest todoRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest, todo);

        todoRepository.save(todo);
        return BaseResponse.getSuccessMessage();
    }

    @Override
    public Todo getById(Long id) {
        Optional<Todo> byId = todoRepository.findById(id);

        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.NOT_FOUND.getMessage());
        }
    }

    @Override
    public List<Todo> getAll() {
        List<Todo> todoList = todoRepository.findAll();

        if (todoList.isEmpty()) {
            throw new TodoNotFoundException(ErrorCodeEnum.NOT_FOUND.getMessage());
        } else {
            return todoList;
        }
    }

    @Override
    public BaseResponse update(Long id, TodoRequest todoRequest) {
        Optional<Todo> byId = todoRepository.findById(id);

        Todo todo;

        if (byId.isPresent()) {
            todo = byId.get();
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.NOT_FOUND.getMessage());
        }

        BeanUtils.copyProperties(todoRequest, todo);
        todoRepository.save(todo);
        return BaseResponse.getSuccessMessage();
    }

    @Override
    public BaseResponse delete(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todoRepository.delete(todo);
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.NOT_FOUND.getMessage());
        }
        return BaseResponse.getSuccessMessage();
    }

}
