package com.example.todo_management.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {

    @NotNull(message = "Name cannot be null!")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long.")
    private String name;

    @NotNull(message = "Surname cannot be null!")
    @Size(min = 3, max = 20, message = "Surname must be between 3 and 20 characters long.")
    private String surname;

}
