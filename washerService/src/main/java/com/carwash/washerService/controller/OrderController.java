package com.carwash.washerService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.washerService.entity.Orders;
import com.carwash.washerService.exception.ResourceNotFoundException;
import com.carwash.washerService.repo.OrderRepository;
import com.carwash.washerService.service.SequenceGeneratorService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<Orders> getOrderById(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		
		Orders orders = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
		return ResponseEntity.ok().body(orders);
		
	}

	@DeleteMapping("/orders/{id}")
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		Orders orders = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Orders not found for this id :: " + orderId));

		orderRepository.delete(orders);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
