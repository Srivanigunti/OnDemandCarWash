package app.carwash.customerService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.carwash.customerService.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long>{

}

