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

import com.mendoza.sportshoes.web.model.Admin;

@Controller
public class AdminController {
	
	private static final String BASE_URL = "http://localhost:8001/admins";
	
	private RestTemplate restTemplate;
	
	@Autowired
	public AdminController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	@GetMapping(path = "/admins/list")
	public ModelAndView listOfAdmins() {
		// make a REST request
		ResponseEntity<List<Admin>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Admin>>() {
				});

		List<Admin> admins = responseEntity.getBody();

		ModelAndView modelAndView = new ModelAndView("list-admins");

		modelAndView.addObject("admins", admins);

		return modelAndView;
	}
	
	@GetMapping(path = "/admins/showFormForAdd")
	public ModelAndView showFormForAddAdmin() {
		ModelAndView modelAndView = new ModelAndView("admin-form");
		Admin theAdmin = new Admin();
		modelAndView.addObject("admin", theAdmin);
		return modelAndView;
	}
	
	@PostMapping(path = "/admins/saveAdmin")
	public ModelAndView saveAdmin(@ModelAttribute("admin") Admin theAdmin) {
		ModelAndView modelAndView = new ModelAndView("redirect:/admins/list");
		restTemplate.postForObject(BASE_URL, theAdmin, Admin.class);
		return modelAndView;
	}
	
	@GetMapping(path = "/admins/showFormForUpdate")
	public ModelAndView showFormForUpdate(@RequestParam("adminId") Integer theId, Model theModel) {
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("theId", theId);
		Admin theAdmin = restTemplate.getForObject(BASE_URL+"/{theId}", Admin.class,params);
		theModel.addAttribute("admin", theAdmin);
		return new ModelAndView("admin-form");
	}
	
	@GetMapping(path="/admins/delete")
	public ModelAndView deleteAdminById(@RequestParam("adminId") Integer theId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("theId", theId);
		restTemplate.delete(BASE_URL+"/{theId}",params);
		
		ResponseEntity<List<Admin>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Admin>>() {
				});

		List<Admin> admins = responseEntity.getBody();

		ModelAndView modelAndView = new ModelAndView("list-admins");

		modelAndView.addObject("admins", admins);

		return modelAndView;
				
	}
	
}
