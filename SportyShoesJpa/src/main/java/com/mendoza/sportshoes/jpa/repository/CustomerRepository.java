package com.mendoza.sportshoes.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendoza.sportshoes.jpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
//	@Query(value = "complex sql")
//	List<Customer> meaningfulmethodname();

}
