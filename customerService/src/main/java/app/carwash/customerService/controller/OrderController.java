package app.carwash.customerService.controller;

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

import app.carwash.customerService.entity.Orders;
import app.carwash.customerService.exception.ResourceNotFoundException;
import app.carwash.customerService.repo.OrderRepository;
import app.carwash.customerService.service.SequenceGeneratorService;

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

	@PostMapping("/orders")
	public Orders createCustomer(@RequestBody Orders orders) {
		orders.setId(sequenceGeneratorService.generateSequence(Orders.SEQUENCE_NAME));
		return orderRepository.save(orders);
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<Orders> updateOrders(@PathVariable(value = "id") Long orderId,
			 @RequestBody Orders orderDetails) throws ResourceNotFoundException {
		Orders orders = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Orders not found for this id :: " + orderId));

		orders.setId(orderDetails.getId());
		orders.setWashPackageID(orderDetails.getWashPackageID());
		orders.setWashLocation(orderDetails.getWashLocation());
		final Orders updatedOrders = orderRepository.save(orders);
		return ResponseEntity.ok(updatedOrders);
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
