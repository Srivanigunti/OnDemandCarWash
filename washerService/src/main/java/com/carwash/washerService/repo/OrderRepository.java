package com.carwash.washerService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.washerService.entity.Orders;


@Repository
public interface OrderRepository extends MongoRepository<Orders, Long> {

}
