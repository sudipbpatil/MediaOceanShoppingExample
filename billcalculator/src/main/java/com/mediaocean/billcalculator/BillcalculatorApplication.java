package com.mediaocean.billcalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.mediaocean.billcalculator.product.dao.ProductRepository;


@SpringBootApplication
@EnableCaching
public class BillcalculatorApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BillcalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(productRepository.getOne(1001));
		
		/*
		logger.info("productDao.findAll()"+productDao.findAll());
		logger.info("productDao.findByID(int)"+ productDao.findByID(1));
		
		
		logger.info("productAttributeDao.findByID(1)"+ productAttributeDao.findByID(1));
		logger.info("productAttributeDao.findAll()"+ productAttributeDao.findAll());
		
		logger.info("productDiscountDao.findByID(1)"+ productDiscountDao.findByID(1));
		logger.info("productDiscountDao.findByID(2)"+ productDiscountDao.findByID(2));
		logger.info("productDiscountDao.findByID(3)"+ productDiscountDao.findByID(3));
		*/
	}

}
