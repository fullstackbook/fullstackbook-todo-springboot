package com.example.fullstackbooktodospringboot.dto;

import lombok.Data;

@Data
public class CreateToDoDto {
    private String name;
    private Boolean completed;
}
