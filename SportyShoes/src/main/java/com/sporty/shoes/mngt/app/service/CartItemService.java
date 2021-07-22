package com.sporty.shoes.mngt.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.shoes.mngt.app.dao.CartItemDAO;
import com.sporty.shoes.mngt.app.entity.CartItem;

@Service
public class CartItemService {
	
	
	@Autowired
	private CartItemDAO cartItemdao;

	public Iterable<CartItem> findAllCartItems() {
		return cartItemdao.findAll();
	}

	public void addCartItem(CartItem cartItem) {
		cartItemdao.save(cartItem);
	}
	
	public void deleteCartItem(CartItem cartItem) {
		cartItemdao.delete(cartItem);
	}
	
	public void updateCartItem(CartItem cartItem) {
		cartItemdao.deleteById(cartItem.getID());
		cartItemdao.save(cartItem);
	}
	
	public Iterable<CartItem> findCartItemByName(String name) {
		return cartItemdao.findByname(name);
	}
	
	
}