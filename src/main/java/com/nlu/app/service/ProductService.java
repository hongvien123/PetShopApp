package com.nlu.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.nlu.app.entity.ProductEntity;

public interface ProductService {
	
	public List<ProductEntity> getAllProduct();
	public Optional<ProductEntity> getProductById(Long id);
	public List<ProductEntity> getLastestProduct(Date date);
	public List<ProductEntity> getDiscountProduct(Integer discount);
	public List<ProductEntity> getSellProduct(Integer sold);

}
