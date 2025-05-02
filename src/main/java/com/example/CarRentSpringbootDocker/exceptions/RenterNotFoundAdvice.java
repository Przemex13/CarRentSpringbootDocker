package com.example.CarRentSpringbootDocker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RenterNotFoundAdvice {
    @ExceptionHandler(RenterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String renterNotFoundController(RenterNotFoundException exception){
        return exception.getMessage();
    }
}
