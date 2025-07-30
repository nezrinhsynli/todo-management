package com.example.todo_management.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {

    private String title;
    private String text;

}
