package com.mendoza.sportshoes.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mendoza.sportshoes.web.model.Category;

@Controller
public class CategoryController {
	
	private static final String BASE_URL = "http://localhost:8001/categories";
	
	private RestTemplate restTemplate;
	
	@Autowired
	public CategoryController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	@GetMapping(path = "/categories/list")
	public ModelAndView listOfCategories() {
		// make a REST request
		ResponseEntity<List<Category>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Category>>() {
				});

		List<Category> categories = responseEntity.getBody();

		ModelAndView modelAndView = new ModelAndView("list-categories");

		modelAndView.addObject("categories", categories);

		return modelAndView;
	}
	
	@GetMapping(path = "/categories/showFormForAdd")
	public ModelAndView showFormForAddCategory() {
		ModelAndView modelAndView = new ModelAndView("category-form");
		Category theCategory = new Category();
		modelAndView.addObject("category", theCategory);
		return modelAndView;
	}
	
	@PostMapping(path = "/categories/saveCategory")
	public ModelAndView saveCategory(@ModelAttribute("category") Category theCategory) {
		ModelAndView modelAndView = new ModelAndView("redirect:/categories/list");
		restTemplate.postForObject(BASE_URL, theCategory, Category.class);
		return modelAndView;
	}
	
	@GetMapping(path = "/categories/showFormForUpdate")
	public ModelAndView showFormForUpdate(@RequestParam("categoryId") Integer theId, Model theModel) {
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("theId", theId);
		Category theCategory = restTemplate.getForObject(BASE_URL+"/{theId}", Category.class,params);
		theModel.addAttribute("category", theCategory);
		return new ModelAndView("category-form");
	}
	
	@GetMapping(path="/categories/delete")
	public ModelAndView deleteCategoryById(@RequestParam("categoryId") Integer theId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("theId", theId);
		restTemplate.delete(BASE_URL+"/{theId}",params);
		
		ResponseEntity<List<Category>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Category>>() {
				});

		List<Category> categories = responseEntity.getBody();

		ModelAndView modelAndView = new ModelAndView("list-categories");

		modelAndView.addObject("categories", categories);

		return modelAndView;
				
	}
	
}
