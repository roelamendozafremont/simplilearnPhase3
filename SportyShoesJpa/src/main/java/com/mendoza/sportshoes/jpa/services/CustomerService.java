package com.mendoza.sportshoes.jpa.services;

import java.util.List;

import com.mendoza.sportshoes.jpa.model.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	public Customer saveCustomer(Customer theCustomer);
	public Customer getCustomer(Integer theId);
	public void deleteCustomer(Integer theid);

}
