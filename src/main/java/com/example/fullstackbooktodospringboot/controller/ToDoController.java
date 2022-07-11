package com.example.fullstackbooktodospringboot.controller;

import com.example.fullstackbooktodospringboot.dto.CreateToDoDTO;
import com.example.fullstackbooktodospringboot.dto.ToDoDTO;
import com.example.fullstackbooktodospringboot.dto.UpdateToDoDTO;
import com.example.fullstackbooktodospringboot.service.ToDoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    private ToDoService toDoService;

    @Value("${spring.application.name}")
    private String name;

    public ToDoController (ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/")
    public String getRoot() {
        return name;
    }

    @PostMapping("/todos")
    public ResponseEntity<ToDoDTO> createToDo(@RequestBody CreateToDoDTO newToDo) {
        ToDoDTO toDoDTO = toDoService.createTodo(newToDo);
        return new ResponseEntity<>(toDoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public List<ToDoDTO> getToDos() {
        return toDoService.getToDos();
    }

    @GetMapping("/todos/{id}")
    public ToDoDTO getToDoById(@PathVariable Long id) {
        return toDoService.getToDoById(id);
    }

    @PutMapping("/todos/{id}")
    public ToDoDTO updateToDo(@PathVariable Long id, @RequestBody UpdateToDoDTO updateToDo) {
        return toDoService.updateToDo(id, updateToDo);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
