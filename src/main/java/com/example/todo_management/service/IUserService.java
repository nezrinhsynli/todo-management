package com.example.todo_management.service;

import com.example.todo_management.dto.request.UserRequest;
import com.example.todo_management.entities.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User findByNameAndSurname (String name, String surname);

    void createUser(UserRequest userRequest);

    void updateUser(Long id, UserRequest userRequest);

    void updateUserPartially(Long id, UserRequest userRequest);

    void deleteUser(Long id);

}
