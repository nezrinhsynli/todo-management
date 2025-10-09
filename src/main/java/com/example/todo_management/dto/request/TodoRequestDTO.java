package com.example.todo_management.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoRequestDTO {

    private String title;
    private String text;

}
