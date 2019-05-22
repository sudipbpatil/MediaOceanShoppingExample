package com.mediaocean.billcalculator.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mediaocean.billcalculator.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
