package com.example.CarRentSpringbootDocker.controller;

import com.example.CarRentSpringbootDocker.dto.CarDto;
import com.example.CarRentSpringbootDocker.entity.Car;
import com.example.CarRentSpringbootDocker.exceptions.CarNotFoundException;
import com.example.CarRentSpringbootDocker.repository.CarRepository;
import com.example.CarRentSpringbootDocker.service.CarService;
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
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;
    private final CarService carService;
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);


    public CarController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
    }

    //    get

    @GetMapping("/przemas")
    String metoda(){
        return "Przemo mistrz";
    }

    //    get car by id

    @GetMapping("/{id}")
    public ResponseEntity <Car> showCar (@PathVariable Long id){

        return ResponseEntity.ok(carService.findCarById(id)
                .orElseThrow(() -> new CarNotFoundException(id)));
    }

    //    get all cars

    @GetMapping("/all")
    List<Car> allCars(){
        return  carRepository.findAll();
    }

    //    add new car

    @PostMapping("/add")
    public ResponseEntity<Car> addCar (@RequestBody CarDto dto){

        Car car = Car.builder()
                .brand(dto.getBrand())
                .modelName(dto.getModelName())
                .registrationNumber(dto.getRegistrationNumber())
                .yearOfProduction(dto.getYearOfProduction())
                .colour(dto.getColour())
                .build();

        Car saved = carService.saveCar(car);

        return ResponseEntity.ok(saved);
    }


    //    delete car

    @DeleteMapping("delete/{id}")
    void deleteCar (@PathVariable Long id){
        carService.deleteCar(id);
    }

    //    update car with Builder

//    @PutMapping("update/{id}")
//    ResponseEntity<Car>updateCar(@RequestBody Car modifiedCar,@PathVariable Long id){
//
//        Car car = Car.builder()
//                .id(id)
//                .brand(modifiedCar.getBrand())
//                .modelName(modifiedCar.getModelName())
//                .registrationNumber(modifiedCar.getRegistrationNumber())
//                .yearOfProduction(modifiedCar.getYearOfProduction())
//                .colour(modifiedCar.getColour())
//                .build();
//
//        Car carUpdated = carService.saveCar(car);
//
//        return ResponseEntity.ok(carUpdated);
//    }


//      update car with lambda

    @PutMapping("update/{id}")
    Car updateCarWithLambda(@RequestBody Car modifiedCar,@PathVariable Long id){

        return carService.findCarById(id)
                .map(car ->{
                    car.setBrand(modifiedCar.getBrand());
                    car.setModelName(modifiedCar.getModelName());
                    car.setRegistrationNumber(modifiedCar.getRegistrationNumber());
                    car.setYearOfProduction(modifiedCar.getYearOfProduction());
                    car.setColour(modifiedCar.getColour());
                    return carService.saveCar(car);
                })
                .orElseThrow(() -> new CarNotFoundException(id));
    }
}