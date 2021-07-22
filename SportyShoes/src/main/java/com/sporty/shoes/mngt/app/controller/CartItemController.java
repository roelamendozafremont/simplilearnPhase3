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

import com.sporty.shoes.mngt.app.entity.CartItem;
import com.sporty.shoes.mngt.app.service.CartItemService;


@RestController
@RequestMapping("/cart-item-management")
public class CartItemController {
	
	

	@Autowired
	private CartItemService service;

	
	@GetMapping("/findAllCartItems")
	public Iterable<CartItem> findAllAdmins() {
		// TODO Auto-generated method stub
		Iterable<CartItem> icartitems = service.findAllCartItems();
		icartitems.forEach((p) -> System.out.println(p.returnPrintString()));
		return icartitems;
	}
	
	@GetMapping("/findCartItemByName/{name}")
	public Iterable<CartItem> findCartItemByName(@PathVariable("name") String name) {
		// TODO Auto-generated method stub
		Iterable<CartItem> icartitems = service.findCartItemByName(name);
		icartitems.forEach((p) -> System.out.println(p.returnPrintString()));
		return icartitems;
	}
	
	@PostMapping("/addCartItem")
	public void addCartItem(@NonNull  @RequestBody CartItem cartitem) {
		service.addCartItem(cartitem);
		System.out.println("added to repo ==> " + cartitem.returnPrintString());
	}
	
	@DeleteMapping("/deleteCartItem")
	public void deleteCartItem(@NonNull  @RequestBody CartItem cartitem) {
		service.deleteCartItem(cartitem);
		System.out.println("deleted from repo ==> " + cartitem.returnPrintString());
	}

	@PutMapping("/updateCartItem")
	public void updateAdmin(@NonNull  @RequestBody CartItem cartitem) {
		service.updateCartItem(cartitem);
		System.out.println("updated to repo ==> " + cartitem.returnPrintString());
	}
	
	
	
	
}