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

import com.carwash.adminService.entity.User;
import com.carwash.adminService.exception.ResourceNotFoundException;
import com.carwash.adminService.repo.UserRepository;
import com.carwash.adminService.service.SequenceGeneratorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	

	@GetMapping("/user")
	public List<User> getAllServicePlans() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{user_id}")
	public ResponseEntity<User> getservicePlanById(@PathVariable(value = "servicePlan_id") Long user_id)
			throws ResourceNotFoundException {
		User user = userRepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + user_id));
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		user.setUser_id(sequenceGeneratorService.generateSequence(user.SEQUENCE_NAME));
		return userRepository.save(user);
	}
	@PutMapping("/user/{user_id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "user_id") Long user_id,
			 @RequestBody User servicePlanDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + user_id));

		user.setName(user.getName());
		user.setPhone(user.getPhone());
		user.setPassword(user.getPassword());
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	@DeleteMapping("/user/{user_id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "user_id") Long user_id)
			throws ResourceNotFoundException {
		User user = userRepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + user_id));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
