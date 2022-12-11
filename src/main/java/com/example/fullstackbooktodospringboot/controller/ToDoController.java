package com.example.fullstackbooktodospringboot.controller;

import com.example.fullstackbooktodospringboot.dto.*;
import com.example.fullstackbooktodospringboot.projection.ToDoView;
import com.example.fullstackbooktodospringboot.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private ToDoService toDoService;

    public ToDoController (ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("")
    public ResponseEntity<ToDoDto> createToDo(@RequestBody CreateToDoDto newToDo) {
        ToDoDto toDoDTO = toDoService.createTodo(newToDo);
        return new ResponseEntity<>(toDoDTO, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<ToDoDto> getToDos(@RequestParam Optional<Boolean> completed) {
        if (completed.isPresent()) {
            return toDoService.getToDos(completed.get());
        }
        return toDoService.getToDos();
    }

    @GetMapping("/testInterfaceProjection")
    public List<ToDoView> testInterfaceProjection() {
        return toDoService.getAllToDoViews();
    }

    @GetMapping("/testClassBasedProjection")
    public List<ToDoNameDto> testClassBasedProjection(@RequestParam String name) {
        return toDoService.getNamesByName(name);
    }

    @GetMapping("/testClassBasedProjectionWithJpqlQuery")
    public List<ToDoNameDto> testClassBasedProjectionWithJpqlQuery() {
        return toDoService.getAllToDoNameDtos();
    }

    @GetMapping("/testDynamicProjection")
    public List<ToDoNameDto> testDynamicProjection(@RequestParam String name) {
        return toDoService.findAllNamesByName(name);
    }

    @GetMapping("/testDynamicProjection2")
    public List<ToDoIdDto> testDynamicProjection2(@RequestParam String name) {
        return toDoService.findAllIdsByName(name);
    }

    @GetMapping("/{id}")
    public ToDoDto getToDoById(@PathVariable Long id) {
        return toDoService.getToDoById(id);
    }

    @PutMapping("/{id}")
    public ToDoDto updateToDo(@PathVariable Long id, @RequestBody UpdateToDoDto updateToDoDto) {
        return toDoService.updateToDo(id, updateToDoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
