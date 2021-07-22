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

import com.sporty.shoes.mngt.app.entity.Purchase;
import com.sporty.shoes.mngt.app.service.PurchaseService;


@RestController
@RequestMapping("/purchase-management")
public class PurchaseController {
	
	

	@Autowired
	private PurchaseService service;

	
	@GetMapping("/findAllPurchases")
	public Iterable<Purchase> findAllPurchases() {
		// TODO Auto-generated method stub
		Iterable<Purchase> ipurchases = service.findAllPurchases();
		ipurchases.forEach((p) -> System.out.println(p.returnPrintString()));
		return ipurchases;
	}
	
	@GetMapping("/findPurchasesByUserId/{userid}")
	public Iterable<Purchase> findPurchasesByUserId(@PathVariable("userid") String userid) {
		// TODO Auto-generated method stub
		Iterable<Purchase> ipurchases = service.findPurchaseByUserId(userid);
		ipurchases.forEach((p) -> System.out.println(p.returnPrintString()));
		return ipurchases;
	}
	
	@PostMapping("/addPurchase")
	public void addPurchase(@NonNull @RequestBody Purchase purchase) {
		service.addPurchase(purchase);
		System.out.println("added to repo ==> " + purchase.returnPrintString());
	}
	
	@DeleteMapping("/deletePurchase")
	public void deletePurchase(@NonNull  @RequestBody Purchase purchase) {
		service.deletePurchase(purchase);
		System.out.println("deleted from repo ==> " + purchase.returnPrintString());
	}

	@PutMapping("/updatePurchase")
	public void updatePurchase(@NonNull  @RequestBody Purchase purchase) {
		service.updatePurchase(purchase);
		System.out.println("updated to repo ==> " + purchase.returnPrintString());
	}
	
	
	
	
}