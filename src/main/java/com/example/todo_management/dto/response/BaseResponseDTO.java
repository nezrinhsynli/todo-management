package com.example.todo_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponseDTO {

    private String message;
    private LocalDateTime timestamp;

    public static BaseResponseDTO getSuccessMessage() {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setMessage("Process success compiled");
        baseResponseDTO.setTimestamp(LocalDateTime.now());
        return baseResponseDTO;
    }

}
