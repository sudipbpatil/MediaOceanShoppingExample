package com.mediaocean.billcalculator.product.Interface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediaocean.billcalculator.product.dao.ProductRepository;
import com.mediaocean.billcalculator.product.entity.Product;
import com.mediaocean.billcalculator.service.exception.ProductNotFoundException;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/product")
	@Cacheable("products")
	public List<Product> retriveAllProducts(){
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	@Cacheable("Product")
	@GetMapping("/product/{productId}")
	public Product retriveProductById(@PathVariable Integer productId){
		 Optional<Product> product = productRepository.findById(productId);
		 return product.get();
	}
	
	@DeleteMapping("/product/{productId}")
	public void deleteProduct(@PathVariable Integer productId) {
		productRepository.deleteById(productId);
	}
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		Product product2 = productRepository.save(product);
		return product2; 
	}
	
	
	
}
