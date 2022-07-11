package com.example.fullstackbooktodospringboot.exception;

import org.springframework.http.HttpStatus;

public class ToDoException extends RuntimeException {
    private HttpStatus httpStatus;

    public ToDoException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
