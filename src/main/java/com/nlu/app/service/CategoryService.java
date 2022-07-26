package com.nlu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.app.entity.Category;
import com.nlu.app.entity.Product;
import com.nlu.app.repository.CategoryRepository;

public interface CategoryService {

	List<Category> findAll();


}
