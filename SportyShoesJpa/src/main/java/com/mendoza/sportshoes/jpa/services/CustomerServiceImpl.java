package com.mendoza.sportshoes.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendoza.sportshoes.jpa.model.Customer;
import com.mendoza.sportshoes.jpa.repository.CustomerRepository;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		return customerRepository.save(theCustomer);
	}

	@Override
	public Customer getCustomer(Integer theId) {
		return customerRepository.findById(theId).get();
	}

	@Override
	public void deleteCustomer(Integer theid) {
		customerRepository.deleteById(theid);

	}

}
