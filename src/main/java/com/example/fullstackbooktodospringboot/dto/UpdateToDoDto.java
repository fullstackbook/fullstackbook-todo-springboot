package com.example.fullstackbooktodospringboot.dto;

import lombok.Data;

@Data
public class UpdateToDoDto {
    private String name;
    private Boolean completed;
}
