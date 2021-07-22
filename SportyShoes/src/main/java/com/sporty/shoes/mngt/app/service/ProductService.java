package com.sporty.shoes.mngt.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.shoes.mngt.app.dao.ProductDAO;
import com.sporty.shoes.mngt.app.entity.Product;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductDAO productdao;

	public Iterable<Product> findAllProducts() {
		return productdao.findAll();
	}

	public void addProduct(Product product) {
		productdao.save(product);
	}
	
	public void deleteProduct(Product product) {
		productdao.delete(product);
	}
	
	public void updateProduct(Product product) {
		productdao.deleteById(product.getID());
		productdao.save(product);
	}
	
	public Iterable<Product> findProductByName(String name) {
		return productdao.findByname(name);
	}
}