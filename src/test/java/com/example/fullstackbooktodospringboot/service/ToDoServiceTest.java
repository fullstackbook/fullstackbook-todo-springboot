package com.example.fullstackbooktodospringboot.service;

import com.example.fullstackbooktodospringboot.dto.ToDoDto;
import com.example.fullstackbooktodospringboot.model.ToDo;
import com.example.fullstackbooktodospringboot.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoServiceTest {

    @Autowired
    private ToDoService toDoService;

    @MockBean
    private ToDoRepository toDoRepository;

    @Test
    public void getToDosShouldReturnTodos() throws Exception {
        List<ToDo> todos = new ArrayList<>();
        ToDo todo = new ToDo();
        todo.setId(1L);
        todo.setName("write unit tests");
        todo.setCompleted(false);
        todos.add(todo);
        when(toDoRepository.findAll()).thenReturn(todos);
        List<ToDoDto> todoDtoList = toDoService.getToDos();
        assertThat(todoDtoList).hasSize(1);
    }
}
