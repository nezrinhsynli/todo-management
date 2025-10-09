package com.example.todo_management.controller;

import com.example.todo_management.dto.request.UserRequestDTO;
import com.example.todo_management.entities.UserEntity;
import com.example.todo_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public Long createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/search")
    public UserRequestDTO findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return userService.findByNameAndSurname(name, surname);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        userService.updateUser(id, userRequestDTO);
    }

    @PatchMapping("/{id}")
    public void updateUserPartially(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        userService.updateUserPartially(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
