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

import com.sporty.shoes.mngt.app.entity.User;
import com.sporty.shoes.mngt.app.service.UserService;


@RestController
@RequestMapping("/user-management")
public class UserController {
	
	

	@Autowired
	private UserService service;

	
	@GetMapping("/findAllUsers")
	public Iterable<User> findAllUsers() {
		// TODO Auto-generated method stub
		Iterable<User> iusers = service.findAllUsers();
		iusers.forEach((p) -> System.out.println(p.returnPrintString()));
		return iusers;
	}
	
	@GetMapping("/findUsersByFirstName/{fname}")
	public Iterable<User> findUsersByFirstName(@PathVariable("fname") String fname) {
		// TODO Auto-generated method stub
		Iterable<User> iusers = service.findUsersByFName(fname);
		iusers.forEach((p) -> System.out.println(p.returnPrintString()));
		return iusers;
	}
	
	@PostMapping("/addUser")
	public void addUser(@NonNull @RequestBody User user) {
		service.addUser(user);
		System.out.println("added to repo ==> " + user.returnPrintString());
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@NonNull @RequestBody User user) {
		service.deleteUser(user);
		System.out.println("deleted from repo ==> " + user.returnPrintString());
	}

	@PutMapping("/updateUser")
	public void updateUser(@NonNull @RequestBody User user) {
		service.updateUser(user);
		System.out.println("updated to repo ==> " + user.returnPrintString());
	}
	
	
	
	
}