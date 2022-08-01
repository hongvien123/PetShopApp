package com.nlu.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.app.entity.CartItem;
import com.nlu.app.entity.Product;
import com.nlu.app.entity.User;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	public List<CartItem> findAll();
	public void deleteById(Long id);
	public CartItem getByProductId(Long id);
	public CartItem getById(Long id);
}
