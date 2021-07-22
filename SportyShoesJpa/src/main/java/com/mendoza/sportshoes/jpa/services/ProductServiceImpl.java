package com.mendoza.sportshoes.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendoza.sportshoes.jpa.model.Product;
import com.mendoza.sportshoes.jpa.repository.ProductRepository;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product theProduct) {
		return productRepository.save(theProduct);
	}

	@Override
	public Product getProduct(Integer theId) {
		return productRepository.findById(theId).get();
	}

	@Override
	public void deleteProduct(Integer theid) {
		productRepository.deleteById(theid);

	}

}
