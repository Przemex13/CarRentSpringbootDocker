package com.example.CarRentSpringbootDocker.service;

import com.example.CarRentSpringbootDocker.entity.Rental;
import com.example.CarRentSpringbootDocker.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentalService {


    private final RentalRepository rentalRepository;

    RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }
    public Optional<Rental>findRentalById(Long id){
        return rentalRepository.findById(id);
    }

    public Rental saveRental(Rental rental){
        return rentalRepository.save(rental);
    }
    public void deleteRental (Long rentalId){
        rentalRepository.deleteById(rentalId);
    }
}
