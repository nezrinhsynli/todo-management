package com.example.todo_management.service;

import com.example.todo_management.dto.request.TodoRequest;
import com.example.todo_management.dto.response.BaseResponse;
import com.example.todo_management.entities.Todo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ITodoServiceConcurrent {

    CompletableFuture<BaseResponse> save(TodoRequest todoRequest);

    CompletableFuture<Todo> getById(Long id);

    CompletableFuture<List<Todo>> getAll();

    CompletableFuture<BaseResponse> update(Long id, TodoRequest todoRequest);

    CompletableFuture<BaseResponse>  delete(Long id);

}
