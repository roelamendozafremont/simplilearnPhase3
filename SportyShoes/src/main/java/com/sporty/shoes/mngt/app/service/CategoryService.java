package com.sporty.shoes.mngt.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.shoes.mngt.app.dao.CategoryDAO;
import com.sporty.shoes.mngt.app.entity.Category;

@Service
public class CategoryService {
	
	
	@Autowired
	private CategoryDAO categorydao;

	public Iterable<Category> findAllCategories() {
		return categorydao.findAll();
	}

	public void addCategory(Category category) {
		categorydao.save(category);
	}
	
	public void deleteCategory(Category category) {
		categorydao.delete(category);
	}
	
	public void updateCategory(Category category) {
		categorydao.deleteById(category.getID());
		categorydao.save(category);
	}
	
	public Iterable<Category> findCategoryByName(String name) {
		return categorydao.findByname(name);
	}
}