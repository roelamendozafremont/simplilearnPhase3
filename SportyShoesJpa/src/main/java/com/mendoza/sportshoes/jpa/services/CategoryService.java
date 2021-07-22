package com.mendoza.sportshoes.jpa.services;

import java.util.List;

import com.mendoza.sportshoes.jpa.model.Category;

public interface CategoryService {
	
	public List<Category> getCategories();
	public Category saveCategory(Category theCategory);
	public Category getCategory(Integer theId);
	public void deleteCategory(Integer theid);

}
