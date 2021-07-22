package com.mendoza.sportshoes.jpa.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mendoza.sportshoes.jpa.exceptions.DataNotFoundException;
import com.mendoza.sportshoes.jpa.model.Category;
import com.mendoza.sportshoes.jpa.services.CategoryService;


@RestController
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	

	@GetMapping("/categories")
	public List<Category> retrieveAllCategories(){
		return categoryService.getCategories();
	}
	
	@GetMapping("/categories/{theId}")
	public Category retriveCategory(@PathVariable Integer theId) {
		Category theCategory = categoryService.getCategory(theId);
		if ( theCategory == null) {
			throw new DataNotFoundException("id - " + theId);
		}
		return theCategory;
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category theCategory) {
		Category savedCategory = categoryService.saveCategory(theCategory);
		
		URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{theId}")
				 .buildAndExpand(savedCategory.getId())
				 .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/categories/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Integer theId) {
		Category theCategory = categoryService.getCategory(theId);
		if ( theCategory == null) {
			throw new DataNotFoundException("id -" +theId);
		}
		categoryService.deleteCategory(theId);
	}

	@PutMapping("/categories/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCategory(@PathVariable Integer theId,@RequestBody Category theCategory) {
		Category savedCategory = categoryService.getCategory(theId);
		
		savedCategory.setId(theId);
		savedCategory.setName(theCategory.getName());
		savedCategory.setDescription(theCategory.getDescription());
		savedCategory.setCode(theCategory.getCode());
		categoryService.saveCategory(theCategory);
	}
}
