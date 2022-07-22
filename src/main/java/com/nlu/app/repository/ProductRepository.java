package com.nlu.app.repository;

import java.util.Date; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findByDateGreaterThan(Date date);
	public List<Product> findByDiscountGreaterThan(Integer discount);
	public List<Product> findBySoldGreaterThan(Integer sold);
}
