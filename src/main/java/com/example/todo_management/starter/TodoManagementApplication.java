package com.example.todo_management.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.todo_management"})
@ComponentScan(basePackages = {"com.example.todo_management"})
@EnableJpaRepositories(basePackages = {"com.example.todo_management"})
public class TodoManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoManagementApplication.class, args);
	}

}
