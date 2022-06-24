package com.nlu.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.app.entity.ProductEntity;
import com.nlu.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductEntity> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Optional<ProductEntity> getProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<ProductEntity> getLastestProduct(Date date) {
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-DD");
		Date d;
		try {
			d = s.parse("2022-06-20");
			if (date.after(d) == true)
				return productRepository.findAllByDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductEntity> getDiscountProduct(Integer discount) {
		
		return null;
	}

	@Override
	public List<ProductEntity> getSellProduct(Integer sold) {
		// TODO Auto-generated method stub
		return null;
	}

}
