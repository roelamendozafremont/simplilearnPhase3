package com.sporty.shoes.mngt.app.dao;


import org.springframework.data.repository.CrudRepository;

import com.sporty.shoes.mngt.app.entity.CartItem;

public interface CartItemDAO extends CrudRepository<CartItem, String> {

	Iterable<CartItem> findByname(String name);
	
			
}
