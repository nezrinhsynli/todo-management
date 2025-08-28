package com.example.todo_management.service.impl;

import com.example.todo_management.dto.request.TodoRequest;
import com.example.todo_management.dto.response.BaseResponse;
import com.example.todo_management.entities.Todo;
import com.example.todo_management.enums.ErrorCodeEnum;
import com.example.todo_management.exception.TodoNotFoundException;
import com.example.todo_management.repository.TodoRepository;
import com.example.todo_management.service.ITodoServiceConcurrent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@Service
public class TodoServiceConcurrentImpl implements ITodoServiceConcurrent {

    @Autowired
    private TodoRepository todoRepository;

    @Async
    @Override
    public CompletableFuture<BaseResponse> save(TodoRequest todoRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest, todo);

        todoRepository.save(todo);
        return CompletableFuture.completedFuture(BaseResponse.getSuccessMessage());
    }

    @Async
    @Override
    public CompletableFuture<Todo> getById(Long id) {
        Optional<Todo> byId = todoRepository.findById(id);

        if (byId.isPresent()) {
            return CompletableFuture.completedFuture(byId.get());
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.NOT_FOUND.getMessage());
        }
    }

    @Async
    @Override
    public CompletableFuture<List<Todo>> getAll() {
        List<Todo> todoList = todoRepository.findAll();

        if (todoList.isEmpty()) {
            throw new TodoNotFoundException(ErrorCodeEnum.NOT_FOUND.getMessage());
        } else {
            return CompletableFuture.completedFuture(todoList);
        }
    }

    @Async
    @Override
    public CompletableFuture<BaseResponse> update(Long id, TodoRequest todoRequest) {
        Optional<Todo> byId = todoRepository.findById(id);

        Todo todo;

        if (byId.isPresent()) {
            todo = byId.get();
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.NOT_FOUND.getMessage());
        }

        BeanUtils.copyProperties(todoRequest, todo);
        todoRepository.save(todo);
        return CompletableFuture.completedFuture(BaseResponse.getSuccessMessage());
    }

    @Async
    @Override
    public CompletableFuture<BaseResponse> delete(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todoRepository.delete(todo);
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.NOT_FOUND.getMessage());
        }
        return CompletableFuture.completedFuture(BaseResponse.getSuccessMessage());
    }

}
