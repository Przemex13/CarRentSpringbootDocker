package com.example.CarRentSpringbootDocker.repository;

import com.example.CarRentSpringbootDocker.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
