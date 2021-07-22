package com.sporty.shoes.mngt.app.controller;


//import javax.validation.Valid;

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

import com.sporty.shoes.mngt.app.entity.Admin;
import com.sporty.shoes.mngt.app.service.AdminService;


@RestController
@RequestMapping("/admin-management")
public class AdminController {
	
	

	@Autowired
	private AdminService service;

	
	@GetMapping("/findAllAdmins")
	public Iterable<Admin> findAllAdmins() {
		// TODO Auto-generated method stub
		Iterable<Admin> iadmins = service.findAllAdmins();
		iadmins.forEach((p) -> System.out.println(p.returnPrintString()));
		return iadmins;
	}
	
	@GetMapping("/findAdminsByAdminId/{adminId}")
	public Iterable<Admin> findAdminsByAdminId(@PathVariable("adminId") String adminId) {
		// TODO Auto-generated method stub
		Iterable<Admin> iadmins = service.findAdminByadminId(adminId);
		iadmins.forEach((p) -> System.out.println(p.returnPrintString()));
		return iadmins;
	}
	
	@PostMapping("/addAdmin")
	public void addAdmin(@NonNull  @RequestBody Admin admin) {
		service.addAdmin(admin);
		System.out.println("added to repo ==> " + admin.returnPrintString());
	}
	
	@DeleteMapping("/deleteAdmin")
	public void deleteAdmin(@NonNull  @RequestBody Admin admin) {
		service.deleteAdmin(admin);
		System.out.println("deleted from repo ==> " + admin.returnPrintString());
	}

	@PutMapping("/updateAdmin")
	public void updateAdmin(@NonNull  @RequestBody Admin admin) {
		service.updateAdmin(admin);
		System.out.println("updated to repo ==> " + admin.returnPrintString());
	}
	
	
	
	
}