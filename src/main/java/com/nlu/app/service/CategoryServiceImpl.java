package com.nlu.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.app.entity.CategoryEntity;
import com.nlu.app.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public List<CategoryEntity> getAllCategory() {
	
		return categoryRepository.findAll();
	}

}
