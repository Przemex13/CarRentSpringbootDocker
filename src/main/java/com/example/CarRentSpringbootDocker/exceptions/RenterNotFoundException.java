package com.example.CarRentSpringbootDocker.exceptions;

public class RenterNotFoundException extends RuntimeException{

    public RenterNotFoundException(Long id){
        super("Could not found renter id: " + id);
    }
}
