package com.nlu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.app.entity.CartItem;
import com.nlu.app.entity.User;
import com.nlu.app.repository.CartItemRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Override
	public List<CartItem> listCartItem(User user){
		return cartItemRepository.findByUser(user);
	}
}
