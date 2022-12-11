package com.example.fullstackbooktodospringboot.repository;

import com.example.fullstackbooktodospringboot.dto.ToDoNameDto;
import com.example.fullstackbooktodospringboot.model.ToDo;
import com.example.fullstackbooktodospringboot.projection.ToDoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByCompleted(Boolean completed);

    // interface projection with native query
    @Query(value = "select name from todos", nativeQuery = true)
    List<ToDoView> findAllNames();

    // class based projection
    List<ToDoNameDto> findByName(String name);

    // class based projection with jpql expression
    // note: class based projection does not work with native query
    @Query(value = "select new com.example.fullstackbooktodospringboot.dto.ToDoNameDto(t.name) from ToDo t")
    List<ToDoNameDto> getAllNames();

    // dynamic projection
    <T> List<T> findAllByName(String name, Class<T> type);
}
