package com.carwash.washerService.controller;

import java.util.List;

import java.util.HashMap;
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

import com.carwash.washerService.entity.Profile;
import com.carwash.washerService.exception.ResourceNotFoundException;
import com.carwash.washerService.repo.ProfileRepository;
import com.carwash.washerService.service.SequenceGeneratorService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProfileController {
	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/washers")
	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	@GetMapping("/washers/{id}")
	public ResponseEntity<Profile> getProfileById(@PathVariable(value = "id") Long Id)
			throws ResourceNotFoundException {
		Profile profile = profileRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + Id));
		return ResponseEntity.ok().body(profile);
	}

	@PostMapping("/washers")
	public Profile createProfile(@RequestBody Profile profile) {
		profile.setId(sequenceGeneratorService.generateSequence(Profile.SEQUENCE_NAME));
		return profileRepository.save(profile);
	}

	@PutMapping("/washers/{id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") Long Id,
			 @RequestBody Profile profileDetails) throws ResourceNotFoundException {
		Profile profile = profileRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + Id));

		profile.setId(profileDetails.getId());
		profile.setEmailId(profileDetails.getEmailId());
		profile.setLastName(profileDetails.getLastName());
		profile.setFirstName(profileDetails.getFirstName());
		profile.setPassword(profileDetails.getPassword());
		final Profile updatedProfile = profileRepository.save(profile);
		return ResponseEntity.ok(updatedProfile);
	}

	@DeleteMapping("/washers/{id}")
	public Map<String, Boolean> deleteProfile(@PathVariable(value = "id") Long Id)
			throws ResourceNotFoundException {
		Profile profile = profileRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("profile not found for this id :: " + Id));

		profileRepository.delete(profile);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
