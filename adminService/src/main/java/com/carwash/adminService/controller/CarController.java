package com.carwash.adminService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.adminService.entity.CarDetails;
import com.carwash.adminService.exception.ResourceNotFoundException;
import com.carwash.adminService.repo.CarRepository;
import com.carwash.adminService.service.SequenceGeneratorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CarController {
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	

	@GetMapping("/cars")
	public List<CarDetails> getAllCars() {
		return carRepository.findAll();
	}
	@GetMapping("/cars/{carId}")
	public ResponseEntity<CarDetails> getCarById(@PathVariable(value = "carId") Long carId)
			throws ResourceNotFoundException {
		CarDetails carDetails = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("CarDetails not found for this id :: " + carId));
		return ResponseEntity.ok().body(carDetails);
	}
	
	@PostMapping("/cars")
	public CarDetails createCarDetails(@RequestBody CarDetails carDetails) {
		carDetails.setCarId(sequenceGeneratorService.generateSequence(CarDetails.SEQUENCE_NAME));
		return carRepository.save(carDetails);
	}

	@PutMapping("/cars/{carId}")
	public ResponseEntity<CarDetails> updateCarDetails(@PathVariable(value = "carId") Long carId,
			 @RequestBody CarDetails carDetails) throws ResourceNotFoundException {
		CarDetails carDetail = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("CarDetails not found for this id :: " + carId));

		carDetails.setCarname(carDetails.getCarname());
		carDetails.setReg_number(carDetails.getReg_number());
		carDetails.setImageUrl(carDetails.getImageUrl());
		final CarDetails updatedCarDetails = carRepository.save(carDetails);
		return ResponseEntity.ok(updatedCarDetails);
	}
	
	@DeleteMapping("/cars/{carId}")
	public Map<String, Boolean> deleteCarDetails(@PathVariable(value = "carId") Long carId)
			throws ResourceNotFoundException {
		CarDetails carDetails = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("CarDetails not found for this id :: " + carId));

		carRepository.delete(carDetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
