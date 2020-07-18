package com.carwash.washerService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.washerService.entity.Profile;

public interface ProfileRepository extends MongoRepository<Profile, Long> {

}
