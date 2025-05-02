package com.example.CarRentSpringbootDocker.controller;

import com.example.CarRentSpringbootDocker.dto.RentalDto;
import com.example.CarRentSpringbootDocker.entity.Rental;
import com.example.CarRentSpringbootDocker.exceptions.RentalNotFoundException;
import com.example.CarRentSpringbootDocker.repository.RentalRepository;
import com.example.CarRentSpringbootDocker.service.RentalService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalRepository rentalRepository;
    private final RentalService rentalService;
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);


    RentalController(RentalRepository rentalRepository, RentalService rentalService) {
        this.rentalRepository = rentalRepository;
        this.rentalService = rentalService;
    }

    //      get all rentals

    @GetMapping("/all")
    public List<Rental>allRentals(){
        return rentalRepository.findAll();
    }


    //      get rental by id

    @GetMapping("/{id}")
    ResponseEntity<Rental> showRental (@PathVariable Long id){

        return ResponseEntity.ok(rentalService.findRentalById(id)
                .orElseThrow(() -> new RentalNotFoundException(id)));

    }

    //      add new Rental
    @PostMapping("/add")
    public ResponseEntity<Rental>addRental(@RequestBody RentalDto rentalDto){

        Rental rental = Rental.builder()
                .carId(rentalDto.getCarId())
                .renterId(rentalDto.getRenterId())
                .rentDate(rentalDto.getRentDate())
                .returnDate(rentalDto.getReturnDate())
                .audit(rentalDto.getAudit())
                .build();

        Rental saved = rentalService.saveRental(rental);

        return ResponseEntity.ok(saved);
    }

    //    delete Rental
    @DeleteMapping("delete/{id}")
    void deleteRental (@PathVariable Long id){
        rentalService.findRentalById(id);
    }
    @PutMapping("update/{id}")
    Rental UpdateRental(@RequestBody Rental modifiedRental, @PathVariable Long id ){

        return rentalService.findRentalById(id)
                .map(rental ->{
                    rental.setId(modifiedRental.getId());
                    rental.setCarId(modifiedRental.getCarId());
                    rental.setRentDate(modifiedRental.getRentDate());
                    rental.setReturnDate(modifiedRental.getReturnDate());
                    rental.setAudit(modifiedRental.getAudit());
                    return rentalService.saveRental(rental);
                })
                .orElseThrow(() -> new RentalNotFoundException(id));
    }
}
