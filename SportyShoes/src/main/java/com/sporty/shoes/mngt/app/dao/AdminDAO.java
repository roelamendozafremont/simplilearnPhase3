package com.sporty.shoes.mngt.app.dao;


import org.springframework.data.repository.CrudRepository;

import com.sporty.shoes.mngt.app.entity.Admin;

public interface AdminDAO extends CrudRepository<Admin, String> {

	Iterable<Admin> findByadminId(String adminid);
	
			
}
