package com.example.fullstackbooktodospringboot.dto;

import com.example.fullstackbooktodospringboot.model.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ToDoDTO {
    private Long id;
    private String name;
    private Boolean completed;

    public ToDoDTO (ToDo entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.completed = entity.getCompleted();
    }
}
