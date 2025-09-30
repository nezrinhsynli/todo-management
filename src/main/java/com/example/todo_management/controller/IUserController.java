package com.example.todo_management.controller;

import com.example.todo_management.dto.request.UserRequest;
import com.example.todo_management.entities.User;

import java.util.List;

public interface IUserController {

    List<User> getAllUsers();

    void createUser(UserRequest userRequest);

    void updateUser(Long id, UserRequest userRequest);

    void updateUserPartially(Long id, UserRequest userRequest);

    void deleteUser(Long id);

}
