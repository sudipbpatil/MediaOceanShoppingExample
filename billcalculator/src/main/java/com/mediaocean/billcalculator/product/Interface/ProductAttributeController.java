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

import com.mediaocean.billcalculator.product.dao.ProductAttributeRepository;
import com.mediaocean.billcalculator.product.dao.ProductRepository;
import com.mediaocean.billcalculator.product.entity.Product;
import com.mediaocean.billcalculator.product.entity.ProductAttribute;
import com.mediaocean.billcalculator.service.exception.ProductNotFoundException;

@RestController
public class ProductAttributeController {

	@Autowired
	ProductAttributeRepository productAttributeRepository;
	
	@GetMapping("/product/attribute")
	@Cacheable("ProductAttribute")
	public List<ProductAttribute> retriveAllProductAttributes(){
		List<ProductAttribute> productAttributes = productAttributeRepository.findAll();
		return productAttributes;
	}
	
	@Cacheable("ProductAttribute")
	@GetMapping("/product/attribute/{productId}")
	public ProductAttribute retriveProductById(@PathVariable Integer productId){
		 Optional<ProductAttribute> productAttribute = productAttributeRepository.findById(productId);
		 return productAttribute.get();
	}
	
	@DeleteMapping("/product/attribute/{productId}")
	public void deleteProductAttribute(@PathVariable Integer productId) {
		productAttributeRepository.deleteById(productId);
	}
	
	@PostMapping("/product/attribute")
	public ProductAttribute addProduct(@RequestBody ProductAttribute productAttribute) {
		ProductAttribute productAttributeResult = productAttributeRepository.save(productAttribute);
		return productAttributeResult; 
	}
	
	
	
}
