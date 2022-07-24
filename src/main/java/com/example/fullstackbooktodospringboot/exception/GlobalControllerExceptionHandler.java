package com.example.fullstackbooktodospringboot.exception;

import com.example.fullstackbooktodospringboot.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
class GlobalControllerExceptionHandler {
    @ExceptionHandler(ToDoException.class)
    public ResponseEntity<ErrorDto> handleToDoException(ToDoException ex) {
        log.error("todo exception", ex);
        ErrorDto errorDTO = new ErrorDto(ex.getMessage());
        return new ResponseEntity<>(errorDTO, ex.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException ex) {
        log.error("internal server error", ex);
        ErrorDto errorDTO = new ErrorDto("internal server error");
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
