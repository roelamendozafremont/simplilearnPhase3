package com.sporty.shoes.mngt.app.dao;


import org.springframework.data.repository.CrudRepository;

import com.sporty.shoes.mngt.app.entity.Category;

public interface CategoryDAO extends CrudRepository<Category, String> {

	Iterable<Category> findByname(String name);
	
			
}
