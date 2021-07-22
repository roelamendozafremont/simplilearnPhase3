package com.mendoza.sportshoes.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendoza.sportshoes.jpa.model.Admin;
import com.mendoza.sportshoes.jpa.repository.AdminRepository;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin saveAdmin(Admin theAdmin) {
		return adminRepository.save(theAdmin);
	}

	@Override
	public Admin getAdmin(Integer theId) {
		return adminRepository.findById(theId).get();
	}

	@Override
	public void deleteAdmin(Integer theid) {
		adminRepository.deleteById(theid);

	}

}
