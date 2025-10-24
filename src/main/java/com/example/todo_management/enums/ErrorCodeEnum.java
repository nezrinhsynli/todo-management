package com.example.todo_management.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {

    TODO_NOT_FOUND(101, "Todo Not Found."),
    USER_NOT_FOUND(201, "User Not Found");

    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
