package com.example.todo_management.service;

import com.example.todo_management.dto.request.TodoRequestDTO;
import com.example.todo_management.dto.response.BaseResponseDTO;
import com.example.todo_management.dao.entity.TodoEntity;
import com.example.todo_management.enums.ErrorCodeEnum;
import com.example.todo_management.exception.TodoNotFoundException;
import com.example.todo_management.dao.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public synchronized BaseResponseDTO save(TodoRequestDTO todoRequestDTO) {
        TodoEntity todoEntity = new TodoEntity();
        BeanUtils.copyProperties(todoRequestDTO, todoEntity);

        todoRepository.save(todoEntity);
        return BaseResponseDTO.getSuccessMessage();
    }

    public TodoEntity getById(Long id) {
        Optional<TodoEntity> byId = todoRepository.findById(id);

        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.TODO_NOT_FOUND.getMessage());
        }
    }

    public List<TodoEntity> getAll() {
        List<TodoEntity> todoEntityList = todoRepository.findAll();

        if (todoEntityList.isEmpty()) {
            throw new TodoNotFoundException(ErrorCodeEnum.TODO_NOT_FOUND.getMessage());
        } else {
            return todoEntityList;
        }
    }

    public synchronized BaseResponseDTO update(Long id, TodoRequestDTO todoRequestDTO) {
        Optional<TodoEntity> byId = todoRepository.findById(id);
        TodoEntity todoEntity;

        if (byId.isPresent()) {
            todoEntity = byId.get();
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.TODO_NOT_FOUND.getMessage());
        }

        BeanUtils.copyProperties(todoRequestDTO, todoEntity);
        todoRepository.save(todoEntity);
        return BaseResponseDTO.getSuccessMessage();
    }

    public synchronized BaseResponseDTO delete(Long id) {
        Optional<TodoEntity> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            TodoEntity todoEntity = optionalTodo.get();
            todoRepository.delete(todoEntity);
        } else {
            throw new TodoNotFoundException(ErrorCodeEnum.TODO_NOT_FOUND.getMessage());
        }
        return BaseResponseDTO.getSuccessMessage();
    }
}
