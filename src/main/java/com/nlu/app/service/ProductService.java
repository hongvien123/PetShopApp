package com.nlu.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nlu.app.entity.Product;

public interface ProductService {

	List<Product> findBySoldGreaterThan(Integer sold);

	List<Product> findByDiscountGreaterThan(Integer discount);

	List<Product> findByDateGreaterThan(Date date);

	
}
