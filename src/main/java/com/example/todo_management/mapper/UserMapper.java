package com.example.todo_management.mapper;

import com.example.todo_management.dto.request.UserRequestDTO;
import com.example.todo_management.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserEntity toEntity(UserRequestDTO userRequestDTO);

    UserRequestDTO toDTO(UserEntity userEntity);

    List<UserRequestDTO> toDTOList(List<UserEntity> userEntities);

    void updateEntityFromDTO(UserRequestDTO userRequestDTO, @MappingTarget UserEntity userEntity);

}
