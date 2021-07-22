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

import com.sporty.shoes.mngt.app.entity.PurchaseItem;
import com.sporty.shoes.mngt.app.service.PurchaseItemService;


@RestController
@RequestMapping("/purchase-item-management")
public class PurchaseItemController {
	
	

	@Autowired
	private PurchaseItemService service;

	
	@GetMapping("/findAllPurchaseItems")
	public Iterable<PurchaseItem> findAllPurchaseItems() {
		// TODO Auto-generated method stub
		Iterable<PurchaseItem> ipurchaseitems = service.findAllPurchaseItems();
		ipurchaseitems.forEach((p) -> System.out.println(p.returnPrintString()));
		return ipurchaseitems;
	}
	
	@GetMapping("/findPurchaseItemsByUserId/{userid}")
	public Iterable<PurchaseItem> findPurchaseItemsByUserId(@PathVariable("userid") String userid) {
		// TODO Auto-generated method stub
		Iterable<PurchaseItem> ipurchaseitems = service.findPurchaseItemByUserId(userid);
		ipurchaseitems.forEach((p) -> System.out.println(p.returnPrintString()));
		return ipurchaseitems;
	}
	
	@PostMapping("/addPurchaseItem")
	public void addPurchaseItem(@NonNull @RequestBody PurchaseItem purchaseitem) {
		service.addPurchaseItem(purchaseitem);
		System.out.println("added to repo ==> " + purchaseitem.returnPrintString());
	}
	
	@DeleteMapping("/deletePurchaseItem")
	public void deletePurchaseItem(@NonNull @RequestBody PurchaseItem purchaseitem) {
		service.deletePurchaseItem(purchaseitem);
		System.out.println("deleted from repo ==> " + purchaseitem.returnPrintString());
	}

	@PutMapping("/updatePurchaseItem")
	public void updatePurchase(@NonNull  @RequestBody PurchaseItem purchaseitem) {
		service.updatePurchaseItem(purchaseitem);
		System.out.println("updated to repo ==> " + purchaseitem.returnPrintString());
	}
	
	
	
	
}