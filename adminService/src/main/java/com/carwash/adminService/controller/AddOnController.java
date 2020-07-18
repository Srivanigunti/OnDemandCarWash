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

import com.carwash.adminService.entity.AddOn;
import com.carwash.adminService.exception.ResourceNotFoundException;
import com.carwash.adminService.repo.AddOnRepository;
import com.carwash.adminService.service.SequenceGeneratorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AddOnController {
	@Autowired
	private AddOnRepository addOnRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	

	@GetMapping("/addOn")
	public List<AddOn> getAllAddons() {
		return addOnRepository.findAll();
	}

	@GetMapping("/addOn/{addonid}")
	public ResponseEntity<AddOn> getAddOnById(@PathVariable(value = "addonid") Long addonid)
			throws ResourceNotFoundException {
		AddOn addOn = addOnRepository.findById(addonid)
				.orElseThrow(() -> new ResourceNotFoundException("AddOn not found for this id :: " + addonid));
		return ResponseEntity.ok().body(addOn);
	}

	@PostMapping("/addOn")
	public AddOn createAddOn(@RequestBody AddOn addOn) {
		addOn.setAddonid(sequenceGeneratorService.generateSequence(AddOn.SEQUENCE_NAME));
		return addOnRepository.save(addOn);
	}

	@PutMapping("/addOn/{addonid}")
	public ResponseEntity<AddOn> updateAddOn(@PathVariable(value = "addonid") Long addonid,
			 @RequestBody AddOn addOnDetails) throws ResourceNotFoundException {
		AddOn addOn = addOnRepository.findById(addonid)
				.orElseThrow(() -> new ResourceNotFoundException("AddOn not found for this id :: " + addonid));

		addOn.setAddonid(addOn.getAddonid());
		addOn.setName(addOn.getName());
		addOn.setPrice(addOn.getPrice());
		final AddOn updatedAddOn = addOnRepository.save(addOn);
		return ResponseEntity.ok(updatedAddOn);
	}

	@DeleteMapping("/addOn/{addonid}")
	public Map<String, Boolean> deleteAddOn(@PathVariable(value = "addonid") Long addonid)
			throws ResourceNotFoundException {
		AddOn addOn = addOnRepository.findById(addonid)
				.orElseThrow(() -> new ResourceNotFoundException("AddOn not found for this id :: " + addonid));

		addOnRepository.delete(addOn);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
