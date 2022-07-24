package com.example.fullstackbooktodospringboot.dto;

import lombok.Data;

@Data
public class CreateToDoDTO {
    private String name = "";
    private Boolean completed = false;
}
