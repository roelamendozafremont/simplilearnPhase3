package com.mendoza.sportshoes.jpa.services;

import java.util.List;

import com.mendoza.sportshoes.jpa.model.Admin;

public interface AdminService {
	
	public List<Admin> getAdmins();
	public Admin saveAdmin(Admin theAdmin);
	public Admin getAdmin(Integer theId);
	public void deleteAdmin(Integer theid);

}
