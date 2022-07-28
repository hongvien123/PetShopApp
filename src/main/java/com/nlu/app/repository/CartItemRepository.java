package com.nlu.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.app.entity.CartItem;
import com.nlu.app.entity.User;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	public List<CartItem> findByUser(User user);

}
