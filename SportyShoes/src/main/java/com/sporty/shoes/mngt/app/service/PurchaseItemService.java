package com.sporty.shoes.mngt.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.shoes.mngt.app.dao.PurchaseItemDAO;
import com.sporty.shoes.mngt.app.entity.PurchaseItem;

@Service
public class PurchaseItemService {
	
	
	@Autowired
	private PurchaseItemDAO purchaseItemdao;

	public Iterable<PurchaseItem> findAllPurchaseItems() {
		return purchaseItemdao.findAll();
	}

	public void addPurchaseItem(PurchaseItem purchaseItem) {
		purchaseItemdao.save(purchaseItem);
	}
	
	public void deletePurchaseItem(PurchaseItem purchaseItem) {
		purchaseItemdao.delete(purchaseItem);
	}
	
	public void updatePurchaseItem(PurchaseItem purchaseItem) {
		purchaseItemdao.deleteById(purchaseItem.getID());
		purchaseItemdao.save(purchaseItem);
	}
	
	public Iterable<PurchaseItem> findPurchaseItemByUserId(String userid) {
		return purchaseItemdao.findByuserId(userid);
	}
}