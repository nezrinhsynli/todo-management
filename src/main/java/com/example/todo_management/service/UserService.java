package com.example.todo_management.service;

import com.example.todo_management.dto.request.UserRequestDTO;
import com.example.todo_management.entities.UserEntity;
import com.example.todo_management.mapper.UserMapper;
import com.example.todo_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long createUser(UserRequestDTO userRequestDTO) {
        UserEntity userEntity = userMapper.toEntity(userRequestDTO);
        userRepository.save(userEntity);
        return userEntity.getId();
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            throw new RuntimeException();
        }
        return userList;
    }

    public UserRequestDTO findByNameAndSurname(String name, String surname) {
        UserEntity userEntity = userRepository.findByNameAndSurname(name, surname);
        if (userEntity == null) {
            throw new RuntimeException();
        }
        return userMapper.toDTO(userEntity);
    }

    public void updateUser(Long id, UserRequestDTO userRequestDTO) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException());

        userMapper.updateEntityFromDTO(userRequestDTO, userEntity);
        userRepository.save(userEntity);
    }

    public void updateUserPartially(Long id, UserRequestDTO userRequestDTO) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException());

        userMapper.updateEntityFromDTO(userRequestDTO, userEntity);
        userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        userRepository.delete(userEntity);
    }

}
