package com.mendoza.sportshoes.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mendoza.sportshoes.jpa.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
//	@Query(value = "complex sql")
//	List<Customer> meaningfulmethodname();

}
