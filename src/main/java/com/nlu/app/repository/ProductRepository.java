package com.nlu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlu.app.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
