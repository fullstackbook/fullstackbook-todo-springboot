package com.example.fullstackbooktodospringboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {
    @Value("${spring.application.name}")
    private String name;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRoot() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()).andExpect(content().string(containsString(name)));
    }

}
