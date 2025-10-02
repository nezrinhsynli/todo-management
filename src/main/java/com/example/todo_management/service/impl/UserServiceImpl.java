package com.example.todo_management.service.impl;

import com.example.todo_management.dto.request.UserRequest;
import com.example.todo_management.entities.User;
import com.example.todo_management.repository.UserRepository;
import com.example.todo_management.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            throw new RuntimeException();
        } else {
            return userList;
        }
    }

    @Override
    public User findByNameAndSurname(String name, String surname) {
        return userRepository.findByNameAndSurname(name, surname);
    }

    @Override
    public void createUser(UserRequest userRequest) {
        User user = new User();

        BeanUtils.copyProperties(userRequest, user);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserRequest userRequest) {

        Optional<User> byId = userRepository.findById(id);
        User user;

        if (byId.isPresent()) {
            user = byId.get();
        } else {
            throw new RuntimeException();
        }

        BeanUtils.copyProperties(userRequest, user);
        userRepository.save(user);
    }

    @Override
    public void updateUserPartially(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());

        if (userRequest.getName() != null) {
            user.setName(userRequest.getName());
        }
        if (userRequest.getSurname() != null) {
            user.setSurname(userRequest.getSurname());
        }

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> byId = userRepository.findById(id);

        if (byId.isPresent()) {
            userRepository.delete(byId.get());
        } else {
            throw new RuntimeException();
        }
    }

}
