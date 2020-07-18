package app.carwash.customerService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.carwash.customerService.entity.Car;
import app.carwash.customerService.exception.ResourceNotFoundException;
import app.carwash.customerService.repo.CarRepository;
import app.carwash.customerService.service.SequenceGeneratorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CarController {
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/cars")
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Integer carId)
			throws ResourceNotFoundException {
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));
		return ResponseEntity.ok().body(car);
	}
	
	/*@PostMapping("/cars")
	public Car createCar(@RequestBody Car car) {
		car.setId(sequenceGeneratorService.generateSequence(Car.SEQUENCE_NAME));
		return carRepository.save(car);
	}

	@PutMapping("/cars/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable(value = "id") Integer carId,
			 @RequestBody Car carDetails) throws ResourceNotFoundException {
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));

		car.setCarNumber(carDetails.getCarNumber());
		car.setCarImage(carDetails.getCarImage());
		car.setOwnerName(carDetails.getOwnerName());
		final Car updatedCar = carRepository.save(car);
		return ResponseEntity.ok(updatedCar);
	}
	*/
	@DeleteMapping("/cars/{id}")
	public Map<String, Boolean> deleteCar(@PathVariable(value = "id") Integer carId)
			throws ResourceNotFoundException {
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));

		carRepository.delete(car);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
