package com.example.todo_management.service.impl;

import com.example.todo_management.dto.request.TodoRequest;
import com.example.todo_management.entities.Todo;
import com.example.todo_management.repository.TodoRepository;
import com.example.todo_management.service.ITodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void save(TodoRequest todoRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest, todo);

        todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todoRepository.delete(todo);
        } else {
            throw new RuntimeException("Not Found");
        }
    }


}
