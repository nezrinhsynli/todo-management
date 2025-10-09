package com.example.todo_management.exception;

import com.example.todo_management.dto.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TodoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleTodoNotFoundException(TodoNotFoundException ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();

        errorResponseDTO.setMessage(ex.getMessage());
        errorResponseDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseDTO.setTimestamp(LocalDateTime.now());
        return errorResponseDTO;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleException(Exception ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();

        errorResponseDTO.setMessage(ex.getMessage());
        errorResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponseDTO.setTimestamp(LocalDateTime.now());
        return errorResponseDTO;
    }

}
