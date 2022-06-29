package com.nlu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.app.entity.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

}
