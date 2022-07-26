package com.nlu.app.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.app.entity.Category;
import com.nlu.app.entity.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	public List<Category> findAll();
	
}
