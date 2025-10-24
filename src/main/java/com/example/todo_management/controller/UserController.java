package com.example.todo_management.controller;

import com.example.todo_management.dto.request.UserRequestDTO;
import com.example.todo_management.dao.entity.UserEntity;
import com.example.todo_management.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public Long createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/search")
    public UserRequestDTO findUserByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return userService.findUserByNameAndSurname(name, surname);
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.updateUserById(id, userRequestDTO);
    }

    @PatchMapping("/{id}")
    public void updateUserPartially(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.updateUserPartially(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
