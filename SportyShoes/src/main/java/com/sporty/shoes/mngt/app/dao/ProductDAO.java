package com.sporty.shoes.mngt.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.sporty.shoes.mngt.app.entity.Product;

public interface ProductDAO extends CrudRepository<Product, String> {

	Iterable<Product> findByname(String name);
	
			
}


