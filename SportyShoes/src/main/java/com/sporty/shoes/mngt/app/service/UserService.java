package com.sporty.shoes.mngt.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.shoes.mngt.app.dao.UserDAO;
import com.sporty.shoes.mngt.app.entity.User;

@Service
public class UserService {
	
	
	@Autowired
	private UserDAO userdao;

	public Iterable<User> findAllUsers() {
		return userdao.findAll();
	}

	public void addUser(User user) {
		userdao.save(user);
	}
	
	public void deleteUser(User user) {
		userdao.delete(user);
	}
	
	public void updateUser(User user) {
		userdao.deleteById(user.getID());
		userdao.save(user);
	}
	
	public Iterable<User> findUsersByFName(String fname) {
		return userdao.findByfname(fname);
	}
}
