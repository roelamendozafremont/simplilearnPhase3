package com.mendoza.sportshoes.jpa.resources;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mendoza.sportshoes.jpa.exceptions.DataNotFoundException;
import com.mendoza.sportshoes.jpa.model.Product;
import com.mendoza.sportshoes.jpa.services.ProductService;


@RestController
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	

	@GetMapping("/products")
	public List<Product> retrieveAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/products/{theId}")
	public Product retriveProduct(@PathVariable Integer theId) {
		Product theProduct = productService.getProduct(theId);
		if ( theProduct == null) {
			throw new DataNotFoundException("id - " + theId);
		}
		return theProduct;
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product theProduct) {
		Product savedProduct = productService.saveProduct(theProduct);
		
		URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{theId}")
				 .buildAndExpand(savedProduct.getId())
				 .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/products/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Integer theId) {
		Product theProduct = productService.getProduct(theId);
		if ( theProduct == null) {
			throw new DataNotFoundException("id -" +theId);
		}
		productService.deleteProduct(theId);
	}

	@PutMapping("/products/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct(@PathVariable Integer theId,@RequestBody Product theProduct) {
		Product savedProduct = productService.getProduct(theId);
		
		savedProduct.setId(theId);
		savedProduct.setName(theProduct.getName());
		savedProduct.setDescription(theProduct.getDescription());
		savedProduct.setCode(theProduct.getCode());
		savedProduct.setPrice(theProduct.getPrice());
		savedProduct.setDateadded(new Date());
		productService.saveProduct(theProduct);
	}
}
