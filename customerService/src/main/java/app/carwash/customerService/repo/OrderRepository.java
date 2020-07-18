package app.carwash.customerService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.carwash.customerService.entity.Orders;


@Repository
public interface OrderRepository extends MongoRepository<Orders, Long> {

}
