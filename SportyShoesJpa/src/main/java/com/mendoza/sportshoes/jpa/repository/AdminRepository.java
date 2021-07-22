package com.mendoza.sportshoes.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendoza.sportshoes.jpa.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
//	@Query(value = "complex sql")
//	List<Customer> meaningfulmethodname();

}
