package app.carwash.customerService.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.carwash.customerService.entity.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, Integer>{

	Optional<Car> findById(String carId);
	
	Optional<Car> findById(Long carId);
}