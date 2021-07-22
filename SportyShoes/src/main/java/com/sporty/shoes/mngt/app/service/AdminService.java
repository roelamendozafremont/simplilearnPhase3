package com.sporty.shoes.mngt.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.shoes.mngt.app.dao.AdminDAO;
import com.sporty.shoes.mngt.app.entity.Admin;

@Service
public class AdminService {
	
	
	@Autowired
	private AdminDAO admindao;

	public Iterable<Admin> findAllAdmins() {
		return admindao.findAll();
	}

	public void addAdmin(Admin admin) {
		admindao.save(admin);
	}
	
	public void deleteAdmin(Admin admin) {
		admindao.delete(admin);
	}
	
	public void updateAdmin(Admin admin) {
		admindao.deleteById(admin.getID());
		admindao.save(admin);
	}
	
	public Iterable<Admin> findAdminByadminId(String id) {
		return admindao.findByadminId(id);
	}
}
