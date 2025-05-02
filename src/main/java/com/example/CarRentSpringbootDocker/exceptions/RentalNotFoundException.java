package com.example.CarRentSpringbootDocker.exceptions;

public class RentalNotFoundException extends RuntimeException{

    public RentalNotFoundException(Long id){
        super("Could not find rental id: " + id);
    }
}
