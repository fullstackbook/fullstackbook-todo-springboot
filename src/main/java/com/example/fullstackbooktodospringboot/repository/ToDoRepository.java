package com.example.fullstackbooktodospringboot.repository;

import com.example.fullstackbooktodospringboot.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
