package com.example.todo_management.service;

import com.example.todo_management.dto.request.UserRequestDTO;
import com.example.todo_management.dao.entity.UserEntity;
import com.example.todo_management.enums.ErrorCodeEnum;
import com.example.todo_management.exception.UserNotFoundException;
import com.example.todo_management.mapper.UserMapper;
import com.example.todo_management.dao.repository.UserRepository;
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
            throw new UserNotFoundException(ErrorCodeEnum.USER_NOT_FOUND.getMessage());
        }
        return userList;
    }

    public UserRequestDTO findUserByNameAndSurname(String name, String surname) {
        UserEntity userEntity = userRepository.findByNameAndSurname(name, surname);
        if (userEntity == null) {
            throw new UserNotFoundException(ErrorCodeEnum.USER_NOT_FOUND.getMessage());
        }
        return userMapper.toDTO(userEntity);
    }

    public void updateUserById(Long id, UserRequestDTO userRequestDTO) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(ErrorCodeEnum.USER_NOT_FOUND.getMessage()));

        userMapper.updateEntityFromDTO(userRequestDTO, userEntity);
        userRepository.save(userEntity);
    }

    public void updateUserPartially(Long id, UserRequestDTO userRequestDTO) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(ErrorCodeEnum.USER_NOT_FOUND.getMessage()));

        userMapper.updateEntityFromDTO(userRequestDTO, userEntity);
        userRepository.save(userEntity);
    }

    public void deleteUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow((RuntimeException::new));
        userRepository.delete(userEntity);
    }

}
