package com.sporty.shoes.mngt.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.sporty.shoes.mngt.app.entity.Purchase;

public interface PurchaseDAO extends CrudRepository<Purchase, String> {

	Iterable<Purchase> findByuserId(String userId);
	
			
}