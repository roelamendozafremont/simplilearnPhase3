package com.mendoza.sportshoes.jpa.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mendoza.sportshoes.jpa.exceptions.DataNotFoundException;
import com.mendoza.sportshoes.jpa.model.Customer;
import com.mendoza.sportshoes.jpa.services.CustomerService;


@RestController
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	

	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{theId}")
	public Customer retriveCustomer(@PathVariable Integer theId) {
		Customer theCustomer = customerService.getCustomer(theId);
		if ( theCustomer == null) {
			throw new DataNotFoundException("id - " + theId);
		}
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer theCustomer) {
		Customer savedCustomer = customerService.saveCustomer(theCustomer);
		
		URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{theId}")
				 .buildAndExpand(savedCustomer.getId())
				 .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/customers/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Integer theId) {
		Customer theCustomer = customerService.getCustomer(theId);
		if ( theCustomer == null) {
			throw new DataNotFoundException("id -" +theId);
		}
		customerService.deleteCustomer(theId);
	}

	@PutMapping("/customers/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable Integer theId,@RequestBody Customer theCustomer) {
		Customer savedCustomer = customerService.getCustomer(theId);
		
		savedCustomer.setId(theId);
		savedCustomer.setFirstname(theCustomer.getFirstname());
		savedCustomer.setLastname(theCustomer.getLastname());
		savedCustomer.setAddress(theCustomer.getAddress());
		savedCustomer.setEmail(theCustomer.getEmail());
		savedCustomer.setCreditnumber(theCustomer.getCreditnumber());
		customerService.saveCustomer(theCustomer);
	}
}
