package com.carwash.adminService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.adminService.entity.CarDetails;


@Repository
public interface CarRepository extends MongoRepository<CarDetails, Long>{

}

