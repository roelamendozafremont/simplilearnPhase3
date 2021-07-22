package com.sporty.shoes.mngt.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sporty.shoes.mngt.app.entity.Category;
import com.sporty.shoes.mngt.app.service.CategoryService;


@RestController
@RequestMapping("/category-management")
public class CategoryController {
	
	

	@Autowired
	private CategoryService service;

	
	@GetMapping("/findAllCategories")
	public Iterable<Category> findAllCategories() {
		// TODO Auto-generated method stub
		Iterable<Category> icategories = service.findAllCategories();
		icategories.forEach((p) -> System.out.println(p.returnPrintString()));
		return icategories;
	}
	
	@GetMapping("/findCategoriesByName/{name}")
	public Iterable<Category> findCategoriesByName(@PathVariable("name") String name) {
		// TODO Auto-generated method stub
		Iterable<Category> icategories = service.findCategoryByName(name);
		icategories.forEach((p) -> System.out.println(p.returnPrintString()));
		return icategories;
	}
	
	@PostMapping("/addCategory")
	public void addCategory(@NonNull  @RequestBody Category category) {
		service.addCategory(category);
		System.out.println("added to repo ==> " + category.returnPrintString());
	}
	
	@DeleteMapping("/deleteCategory")
	public void deleteCategory(@NonNull  @RequestBody Category category) {
		service.deleteCategory(category);
		System.out.println("deleted from repo ==> " + category.returnPrintString());
	}

	@PutMapping("/updateCategory")
	public void updateCategory(@NonNull  @RequestBody Category category) {
		service.updateCategory(category);
		System.out.println("updated to repo ==> " + category.returnPrintString());
	}
	
	
	
	
}