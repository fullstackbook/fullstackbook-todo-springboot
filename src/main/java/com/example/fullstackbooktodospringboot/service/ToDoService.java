package com.example.fullstackbooktodospringboot.service;

import com.example.fullstackbooktodospringboot.dto.CreateToDoDTO;
import com.example.fullstackbooktodospringboot.dto.ToDoDTO;
import com.example.fullstackbooktodospringboot.dto.UpdateToDoDTO;
import com.example.fullstackbooktodospringboot.exception.ToDoException;
import com.example.fullstackbooktodospringboot.model.ToDo;
import com.example.fullstackbooktodospringboot.repository.ToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private ToDoRepository toDoRepository;

    public ToDoService (ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDoDTO createTodo(CreateToDoDTO createToDoDTO) {
        ToDo newToDo = new ToDo();
        newToDo.setName(createToDoDTO.getName());
        newToDo.setCompleted(createToDoDTO.getCompleted());
        ToDo toDo = toDoRepository.save(newToDo);
        return new ToDoDTO(toDo);
    }

    public List<ToDoDTO> getToDos() {
        List<ToDo> toDos = toDoRepository.findAll();
        return toDos.stream().map(entity -> new ToDoDTO(entity)).toList();
    }

    public ToDoDTO getToDoById(Long id) {
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if (toDo.isPresent()) {
            return new ToDoDTO(toDo.get());
        } else {
            throw new ToDoException("todo not found", HttpStatus.NOT_FOUND);
        }
    }

    public ToDoDTO updateToDo(Long id, UpdateToDoDTO updateToDo) {
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if (toDo.isPresent()) {
            toDo.get().setName(updateToDo.getName());
            toDo.get().setCompleted(updateToDo.getCompleted());
            toDoRepository.save(toDo.get());
            return new ToDoDTO(toDo.get());
        } else {
            throw new ToDoException("to do not found", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteToDo(Long id) {
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if (toDo.isPresent()) {
            toDoRepository.delete(toDo.get());
        } else {
            throw new ToDoException("to do not found", HttpStatus.NOT_FOUND);
        }
    }
}
