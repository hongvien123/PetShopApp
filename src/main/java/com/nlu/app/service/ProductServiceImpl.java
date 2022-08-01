package com.nlu.app.service;

import java.text.ParseException;  
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public List<Product> findByNameContaining(String name) {
		return productRepository.findByNameContaining(name);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByCategoryId(Long categoryId) {
		return productRepository.findByCategoryId(categoryId);
	}

	@Override
	public List<Product> findByObjectAndDiscountGreaterThan(String object, Integer discount) {
		return productRepository.findByObjectAndDiscountGreaterThan(object, discount);
	}

	@Override
	public List<Product> findByObjectAndSoldGreaterThan(String object, Integer sold) {
		return productRepository.findByObjectAndSoldGreaterThan(object, sold);
	}

	@Override
	public List<Product> findByObject(String object) {
		return productRepository.findByObject(object);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.getById(id);
	}

	@Override
	public Page<Product> findByNameContaining(String name, Pageable pageable) {
		return productRepository.findByNameContaining(name, pageable);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
}
