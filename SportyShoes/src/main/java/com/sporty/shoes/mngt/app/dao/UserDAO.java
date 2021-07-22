package com.sporty.shoes.mngt.app.dao;


import org.springframework.data.repository.CrudRepository;

import com.sporty.shoes.mngt.app.entity.User;

public interface UserDAO extends CrudRepository<User, String> {

	Iterable<User> findByfname(String userId);
	
			
}