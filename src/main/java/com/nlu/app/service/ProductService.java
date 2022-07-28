package com.nlu.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nlu.app.entity.Product;

public interface ProductService {

	List<Product> findBySoldGreaterThan(Integer sold);

	List<Product> findByDiscountGreaterThan(Integer discount);

	List<Product> findByDateGreaterThan(Date date);

	List<Product> findByNameContaining(String name);

	List<Product> findAll();

	List<Product> findByCategoryId(Long categoryId);

	List<Product> findByObjectAndSoldGreaterThan(String object, Integer sold);

	List<Product> findByObjectAndDiscountGreaterThan(String object, Integer discount);

	List<Product> findByObject(String object);

	Product getById(Long id);

	Page<Product> findByNameContaining(String name, Pageable pageable);

	Page<Product> findAll(Pageable pageable);

	
}
