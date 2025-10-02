package com.example.todo_management.repository;

import com.example.todo_management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE users.name = :name AND users.surname = :surname", nativeQuery = true)
    User findByNameAndSurname (@Param("name") String name, @Param("surname") String surname);

}
