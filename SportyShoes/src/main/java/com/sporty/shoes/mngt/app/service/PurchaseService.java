package com.sporty.shoes.mngt.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.shoes.mngt.app.dao.PurchaseDAO;
import com.sporty.shoes.mngt.app.entity.Purchase;

@Service
public class PurchaseService {
	
	
	@Autowired
	private PurchaseDAO purchasedao;

	public Iterable<Purchase> findAllPurchases() {
		return purchasedao.findAll();
	}

	public void addPurchase(Purchase purchase) {
		purchasedao.save(purchase);
	}
	
	public void deletePurchase(Purchase purchase) {
		purchasedao.delete(purchase);
	}
	
	public void updatePurchase(Purchase purchase) {
		purchasedao.deleteById(purchase.getID());
		purchasedao.save(purchase);
	}
	
	public Iterable<Purchase> findPurchaseByUserId(String userid) {
		return purchasedao.findByuserId(userid);
	}
}