package com.example.CarRentSpringbootDocker.controller;

import com.example.CarRentSpringbootDocker.dto.RenterDto;
import com.example.CarRentSpringbootDocker.entity.Renter;
import com.example.CarRentSpringbootDocker.exceptions.RenterNotFoundException;
import com.example.CarRentSpringbootDocker.repository.RenterRepository;
import com.example.CarRentSpringbootDocker.service.RenterService;
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
@RequestMapping("/renters")
public class RenterController {

    private final RenterRepository renterRepository;
    private final RenterService renterService;
    private static final Logger logger = LoggerFactory.getLogger(RenterController.class);

    RenterController(RenterRepository renterRepository, RenterService renterService) {
        this.renterRepository = renterRepository;
        this.renterService = renterService;
    }

//    get renter by ID

    @GetMapping("/{id}")
    public ResponseEntity <Renter> showRenter (@PathVariable Long id){

        return ResponseEntity.ok(renterService.findRenterById(id)
                .orElseThrow(() -> new RenterNotFoundException(id)));
    }

//    get all renters

    @GetMapping("/all")
    public List<Renter> allRenters(){
        return renterRepository.findAll();
    }

//    add new renter

    @PostMapping("/add")
    public ResponseEntity<Renter> addRenter(@RequestBody RenterDto dto){

        Renter renter = Renter.builder()
                .imie(dto.getImie())
                .nazwisko(dto.getNazwisko())
                .build();

        Renter saved = renterService.saveRenter(renter);

        return ResponseEntity.ok(renter);
    }

//    delete renter by id
    @DeleteMapping("delete/{id}")
    void deleteRenter(@PathVariable Long id){
        renterService.deleteRenter(id);
    }

//      update Renter
    @PutMapping("update/{id}")
    Renter updateRenter (@RequestBody Renter modifiedRenter, @PathVariable Long id){

        return renterService.findRenterById(id)
                .map( renter -> {
                    renter.setImie(modifiedRenter.getImie());
                    renter.setNazwisko(modifiedRenter.getNazwisko());
                    return renterService.saveRenter(renter);
                })
                .orElseThrow(() -> new RenterNotFoundException(id));
    }






}
