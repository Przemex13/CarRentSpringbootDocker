package com.example.CarRentSpringbootDocker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private String brand;
    private String modelName;
    private String registrationNumber;
    private int yearOfProduction;
    private String colour;

}
