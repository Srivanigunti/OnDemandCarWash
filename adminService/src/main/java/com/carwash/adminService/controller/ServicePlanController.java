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

import com.carwash.adminService.entity.ServicePlan;
import com.carwash.adminService.exception.ResourceNotFoundException;
import com.carwash.adminService.repo.ServicePlanRepository;
import com.carwash.adminService.service.SequenceGeneratorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ServicePlanController {
	@Autowired
	private ServicePlanRepository servicePlanRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	

	@GetMapping("/servicePlan")
	public List<ServicePlan> getAllServicePlans() {
		return servicePlanRepository.findAll();
	}
	
	@GetMapping("/servicePlan/{servicePlan_id}")
	public ResponseEntity<ServicePlan> getservicePlanById(@PathVariable(value = "servicePlan_id") Long servicePlan_id)
			throws ResourceNotFoundException {
		ServicePlan servicePlan = servicePlanRepository.findById(servicePlan_id)
				.orElseThrow(() -> new ResourceNotFoundException("servicePlan not found for this id :: " + servicePlan_id));
		return ResponseEntity.ok().body(servicePlan);
	}

	@PostMapping("/servicePlan")
	public ServicePlan createServicePlan(@RequestBody ServicePlan servicePlan) {
		servicePlan.setServiceplan_id(sequenceGeneratorService.generateSequence(servicePlan.SEQUENCE_NAME));
		return servicePlanRepository.save(servicePlan);
	}

	@PutMapping("/servicePlan/{servicePlan_id}")
	public ResponseEntity<ServicePlan> updateservicePlan(@PathVariable(value = "servicePlan_id") Long servicePlan_id,
			 @RequestBody ServicePlan servicePlanDetails) throws ResourceNotFoundException {
		ServicePlan servicePlan = servicePlanRepository.findById(servicePlan_id)
				.orElseThrow(() -> new ResourceNotFoundException("servicePlan not found for this id :: " + servicePlan_id));

		servicePlan.setServiceplan_id(servicePlan.getServiceplan_id());
		servicePlan.setServiceplan_name(servicePlan.getServiceplan_name());
		servicePlan.setPrice(servicePlan.getPrice());
		final ServicePlan updatedservicePlan = servicePlanRepository.save(servicePlan);
		return ResponseEntity.ok(updatedservicePlan);
	}

	@DeleteMapping("/servicePlan/{servicePlan_id}")
	public Map<String, Boolean> deleteservicePlan(@PathVariable(value = "servicePlan_id") Long servicePlan_id)
			throws ResourceNotFoundException {
		ServicePlan servicePlan = servicePlanRepository.findById(servicePlan_id)
				.orElseThrow(() -> new ResourceNotFoundException("servicePlan not found for this id :: " + servicePlan_id));

		servicePlanRepository.delete(servicePlan);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
