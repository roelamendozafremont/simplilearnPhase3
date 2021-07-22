package com.mendoza.sportshoes.jpa.services;

import java.util.List;

import com.mendoza.sportshoes.jpa.model.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	public Product saveProduct(Product theProduct);
	public Product getProduct(Integer theId);
	public void deleteProduct(Integer theid);

}
