package com.example.todo_management.service;

import com.example.todo_management.dto.request.TodoRequestDTO;
import com.example.todo_management.dto.response.BaseResponseDTO;
import com.example.todo_management.dao.entity.TodoEntity;
import com.example.todo_management.enums.ErrorCodeEnum;
import com.example.todo_management.exception.TodoNotFoundException;
import com.example.todo_management.dao.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@Service
@RequiredArgsConstructor
public class TodoServiceConcurrent {

    private final TodoRepository todoRepository;

    @Async
    public CompletableFuture<BaseResponseDTO> save(TodoRequestDTO todoRequestDTO) {
        TodoEntity todoEntity = new TodoEntity();
        BeanUtils.copyProperties(todoRequestDTO, todoEntity);

        todoRepository.save(todoEntity);
        return CompletableFuture.completedFuture(BaseResponseDTO.getSuccessMessage());
    }

    @Async
    public CompletableFuture<TodoEntity> getById(Long id) {
        Optional<TodoEntity> byId = todoRepository.findById(id);

        if (byId.isPresent()) {
            return CompletableFuture.completedFuture(byId.get());
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.TODO_NOT_FOUND.getMessage());
        }
    }

    @Async
    public CompletableFuture<List<TodoEntity>> getAll() {
        List<TodoEntity> todoEntityList = todoRepository.findAll();

        if (todoEntityList.isEmpty()) {
            throw new TodoNotFoundException(ErrorCodeEnum.TODO_NOT_FOUND.getMessage());
        } else {
            return CompletableFuture.completedFuture(todoEntityList);
        }
    }

    @Async
    public CompletableFuture<BaseResponseDTO> update(Long id, TodoRequestDTO todoRequestDTO) {
        Optional<TodoEntity> byId = todoRepository.findById(id);

        TodoEntity todoEntity;

        if (byId.isPresent()) {
            todoEntity = byId.get();
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.TODO_NOT_FOUND.getMessage());
        }

        BeanUtils.copyProperties(todoRequestDTO, todoEntity);
        todoRepository.save(todoEntity);
        return CompletableFuture.completedFuture(BaseResponseDTO.getSuccessMessage());
    }

    @Async
    public CompletableFuture<BaseResponseDTO> delete(Long id) {
        Optional<TodoEntity> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            TodoEntity todoEntity = optionalTodo.get();
            todoRepository.delete(todoEntity);
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.TODO_NOT_FOUND.getMessage());
        }
        return CompletableFuture.completedFuture(BaseResponseDTO.getSuccessMessage());
    }

}
