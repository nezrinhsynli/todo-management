package com.example.todo_management.exception;

import com.example.todo_management.dto.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO<String> handleUserNotFoundException(UserNotFoundException ex) {

        return ErrorResponseDTO.<String>builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(TodoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO<String> handleTodoNotFoundException(TodoNotFoundException ex) {

        return ErrorResponseDTO.<String>builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO<String> handleException(Exception ex) {

        return ErrorResponseDTO.<String>builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO<Map<String, List<String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errorMap = new HashMap<>();

        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            String fieldName = fieldError.getField();

            if (!errorMap.containsKey(fieldName)) {
                errorMap.put(fieldName, addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
            } else {
                errorMap.put(fieldName, addMapValue(errorMap.get(fieldName), objectError.getDefaultMessage()));
            }
        }

        return ErrorResponseDTO.<Map<String, List<String>>>builder()
                .message(errorMap)
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .build();
    }

    private List<String> addMapValue(List<String> errorsList, String newError) {
        errorsList.add(newError);
        return errorsList;
    }
}



