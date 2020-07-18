package com.carwash.adminService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.adminService.entity.PromoCode;

@Repository
public interface PromoCodeRepository extends MongoRepository<PromoCode, Long>{

}

