package com.sporty.shoes.mngt.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.sporty.shoes.mngt.app.entity.PurchaseItem;

public interface PurchaseItemDAO extends CrudRepository<PurchaseItem, String> {

	Iterable<PurchaseItem> findByuserId(String userId);
	
			
}