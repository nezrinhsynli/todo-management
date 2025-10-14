package com.example.todo_management.dao.repository;

import com.example.todo_management.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByNameAndSurname (String name, String surname);

}
