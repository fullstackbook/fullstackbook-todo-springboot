package com.example.fullstackbooktodospringboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean completed;
}
