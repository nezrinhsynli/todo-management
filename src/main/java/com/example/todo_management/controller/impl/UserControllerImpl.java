package com.example.todo_management.controller.impl;

import com.example.todo_management.controller.IUserController;
import com.example.todo_management.dto.request.UserRequest;
import com.example.todo_management.entities.User;
import com.example.todo_management.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/users")
public class UserControllerImpl implements IUserController {

    private final IUserService userService;

    public UserControllerImpl(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Override
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping(path = "/{id}")
    @Override
    public void updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        userService.updateUser(id, userRequest);
    }

    @PatchMapping(path = "/{id}")
    @Override
    public void updateUserPartially(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        userService.updateUserPartially(id, userRequest);
    }

    @DeleteMapping(path = "{id}")
    @Override
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
