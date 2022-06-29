package com.nlu.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.app.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	public List<ProductEntity> findByName(String name);
	public List<ProductEntity> findAllByDate(Date date);
	public List<ProductEntity> findAllByDiscount(Integer discount);
	public List<ProductEntity> findAllBySold(Integer sold);
}
