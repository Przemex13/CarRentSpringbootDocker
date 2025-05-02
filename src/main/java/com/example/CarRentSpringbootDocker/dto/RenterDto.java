package com.example.CarRentSpringbootDocker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RenterDto {

    private String imie;
    private String nazwisko;
}
