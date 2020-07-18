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

import com.carwash.adminService.entity.PromoCode;
import com.carwash.adminService.exception.ResourceNotFoundException;
import com.carwash.adminService.repo.PromoCodeRepository;
import com.carwash.adminService.service.SequenceGeneratorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PromoCodeController {
	@Autowired
	private PromoCodeRepository promoCodeRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	

	@GetMapping("/promo")
	public List<PromoCode> getAllCars() {
		return promoCodeRepository.findAll();
	}
	@GetMapping("/promo/{promocode}")
	public ResponseEntity<PromoCode> getCarById(@PathVariable(value = "promocode") Long promocode)
			throws ResourceNotFoundException {
		PromoCode promoCode = promoCodeRepository.findById(promocode)
				.orElseThrow(() -> new ResourceNotFoundException("PromoCode not found :: " + promocode));
		return ResponseEntity.ok().body(promoCode);
	}
	@PostMapping("/promo")
	public PromoCode createPromoCode(@RequestBody PromoCode promoCode) {
		promoCode.setPromocode(sequenceGeneratorService.generateSequence(promoCode.SEQUENCE_NAME));
		return promoCodeRepository.save(promoCode);
	}

	@PutMapping("/promo/{promocode}")
	public ResponseEntity<PromoCode> updatePromoCode(@PathVariable(value = "promocode") Long promocode,
			 @RequestBody PromoCode promocodeDetails) throws ResourceNotFoundException {
		PromoCode promoCode = promoCodeRepository.findById(promocode)
				.orElseThrow(() -> new ResourceNotFoundException("promocode not found for this id :: " + promocode));

		promoCode.setPromocode(promoCode.getPromocode());
		promoCode.setDiscount(promoCode.getDiscount());
		final PromoCode updatedpromoCode = promoCodeRepository.save(promoCode);
		return ResponseEntity.ok(updatedpromoCode);
	}
	
	@DeleteMapping("/promo/{promocode}")
	public Map<String, Boolean> deletePromoCode(@PathVariable(value = "promocode") Long promocode)
			throws ResourceNotFoundException {
		PromoCode promoCode = promoCodeRepository.findById(promocode)
				.orElseThrow(() -> new ResourceNotFoundException("promocode not found for this id :: " + promocode));

		promoCodeRepository.delete(promoCode);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}