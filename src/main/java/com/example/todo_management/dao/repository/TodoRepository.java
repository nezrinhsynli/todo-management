package com.example.todo_management.dao.repository;

import com.example.todo_management.dao.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
