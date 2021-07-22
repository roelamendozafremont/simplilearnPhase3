package com.mendoza.sportshoes.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendoza.sportshoes.jpa.model.Category;
import com.mendoza.sportshoes.jpa.repository.CategoryRepository;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category saveCategory(Category theCategory) {
		return categoryRepository.save(theCategory);
	}

	@Override
	public Category getCategory(Integer theId) {
		return categoryRepository.findById(theId).get();
	}

	@Override
	public void deleteCategory(Integer theid) {
		categoryRepository.deleteById(theid);

	}

}
