package com.nlu.app.service;

import java.util.List;

import com.nlu.app.entity.CartItem;
import com.nlu.app.entity.User;

public interface ShoppingCartService {

	void addCartItem(Long id);

	List<CartItem> findAll();

	void deleteById(Long id);

	double getTotal();

	void setTotal();

	CartItem getById(Long id);

	void changeQuantity(Long id, Integer quantity);

}
