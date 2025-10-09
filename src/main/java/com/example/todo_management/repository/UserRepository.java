package com.example.todo_management.repository;

import com.example.todo_management.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByNameAndSurname (String name, String surname);

}
