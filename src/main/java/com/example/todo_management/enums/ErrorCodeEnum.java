package com.example.todo_management.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {

    NOT_FOUND(101, "Todo Not Found.");

    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
