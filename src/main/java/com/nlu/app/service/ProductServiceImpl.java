package com.nlu.app.service;

import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.app.entity.Product;
import com.nlu.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findByDateGreaterThan(Date date) {
		return productRepository.findByDateGreaterThan(date);
	}

	@Override
	public List<Product> findByDiscountGreaterThan(Integer discount) {
		return productRepository.findByDiscountGreaterThan(discount);
	}

	@Override
	public List<Product> findBySoldGreaterThan(Integer sold) {
		return productRepository.findBySoldGreaterThan(sold);
	}

	
	
}
