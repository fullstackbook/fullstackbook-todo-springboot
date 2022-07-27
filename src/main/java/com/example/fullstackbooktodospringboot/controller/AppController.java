package com.example.fullstackbooktodospringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/")
    public String getRoot() {
        return name;
    }
}
