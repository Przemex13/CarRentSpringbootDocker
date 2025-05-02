package com.example.CarRentSpringbootDocker.repository;

import com.example.CarRentSpringbootDocker.entity.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Long> {
}
