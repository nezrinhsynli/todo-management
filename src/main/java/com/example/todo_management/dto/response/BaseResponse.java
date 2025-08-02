package com.example.todo_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    private String message;
    private LocalDateTime timestamp;

    public static BaseResponse getSuccessMessage() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Process success compiled");
        baseResponse.setTimestamp(LocalDateTime.now());
        return baseResponse;
    }

}
