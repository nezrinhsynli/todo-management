package com.example.todo_management.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, length = 20)
    private String title;

    @Column(name = "text", length = 200)
    private String text;

}
