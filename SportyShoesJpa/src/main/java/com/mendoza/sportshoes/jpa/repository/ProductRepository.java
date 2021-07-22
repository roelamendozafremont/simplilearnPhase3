package com.mendoza.sportshoes.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendoza.sportshoes.jpa.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
//	@Query(value = "complex sql")
//	List<Customer> meaningfulmethodname();

}
