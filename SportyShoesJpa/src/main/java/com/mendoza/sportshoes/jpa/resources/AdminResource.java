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
import com.mendoza.sportshoes.jpa.model.Admin;
import com.mendoza.sportshoes.jpa.services.AdminService;


@RestController
public class AdminResource {
	
	@Autowired
	private AdminService adminService;
	
	//Get all the customers URI (/admins)
	//HTTP method GET
//	@RequestMapping(path = "/admins",method = RequestMethod.GET)
	@GetMapping("/admins")
	public List<Admin> retrieveAllAdmins(){
		return adminService.getAdmins();
	}
	
	//GET URI: localhost:8080/admins/101 .. 102 ... 103 so on
	@GetMapping("/admins/{theId}")
	public Admin retriveAdmin(@PathVariable Integer theId) {
		Admin theAdmin= adminService.getAdmin(theId);
		if ( theAdmin == null) {
			throw new DataNotFoundException("id - " + theId);
		}
		return theAdmin;
	}
	
	//POST URI : localhost:8080/admins
	//Request Body JSON DATA {} --- > Java Object (@RequestBody) --- > binds to parameter
	//Response : status code : 201 , URI --- > new resource in a response header
	@PostMapping("/admins")
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin theAdmin) {
		Admin savedAdmin = adminService.saveAdmin(theAdmin);
		
		// location : localhost:8080/admins/4
		URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{theId}")
				 .buildAndExpand(savedAdmin.getId())
				 .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/admins/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteAdmin(@PathVariable Integer theId) {
		Admin theAdmin = adminService.getAdmin(theId);
		if ( theAdmin == null) {
			throw new DataNotFoundException("id -" +theId);
		}
		adminService.deleteAdmin(theId);
	}

	// assigment  : update the customer @PutMapping
	//response : 204
	@PutMapping("/admins/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateAdmin(@PathVariable Integer theId,@RequestBody Admin theAdmin) {
		Admin savedAdmin = adminService.getAdmin(theId);
		
		savedAdmin.setId(theId);
		savedAdmin.setName(theAdmin.getName());
		savedAdmin.setPassword(theAdmin.getPassword());
		savedAdmin.setEmail(theAdmin.getEmail());
		
		adminService.saveAdmin(theAdmin);
	}
}
