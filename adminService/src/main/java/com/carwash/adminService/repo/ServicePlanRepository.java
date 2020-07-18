package com.carwash.adminService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.adminService.entity.ServicePlan;


@Repository
public interface ServicePlanRepository extends MongoRepository<ServicePlan, Long>{

}