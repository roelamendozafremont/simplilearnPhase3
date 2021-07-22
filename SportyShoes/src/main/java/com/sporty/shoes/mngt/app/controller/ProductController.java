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

import com.sporty.shoes.mngt.app.entity.Product;
import com.sporty.shoes.mngt.app.service.ProductService;


@RestController
@RequestMapping("/product-management")
public class ProductController {
	
	

	@Autowired
	private ProductService service;

	
	@GetMapping("/findAllProducts")
	public Iterable<Product> findAllProducts() {
		// TODO Auto-generated method stub
		Iterable<Product> iproducts = service.findAllProducts();
		iproducts.forEach((p) -> System.out.println(p.returnPrintString()));
		return iproducts;
	}
	
	@GetMapping("/findProductsByName/{name}")
	public Iterable<Product> findProductsByName(@PathVariable("name") String name) {
		// TODO Auto-generated method stub
		Iterable<Product> iproducts = service.findProductByName(name);
		iproducts.forEach((p) -> System.out.println(p.returnPrintString()));
		return iproducts;
	}
	
	@PostMapping("/addProduct")
	public void addProduct(@NonNull  @RequestBody Product product) {
		service.addProduct(product);
		System.out.println("added to repo ==> " + product.returnPrintString());
	}
	
	@DeleteMapping("/deleteProduct")
	public void deleteProduct(@NonNull  @RequestBody Product product) {
		service.deleteProduct(product);
		System.out.println("deleted from repo ==> " + product.returnPrintString());
	}

	@PutMapping("/updateProduct")
	public void updateProduct(@NonNull  @RequestBody Product product) {
		service.updateProduct(product);
		System.out.println("updated to repo ==> " + product.returnPrintString());
	}
	
	
	
	
}