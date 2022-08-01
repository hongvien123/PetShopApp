package com.nlu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.app.entity.CartItem;
import com.nlu.app.entity.Product;
import com.nlu.app.entity.User;
import com.nlu.app.repository.CartItemRepository;
import com.nlu.app.repository.ProductRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void addCartItem(Long id) {
		Product p = productRepository.getById(id);
		CartItem existed = cartItemRepository.getByProductId(id);
		CartItem c = new CartItem(p, 1, p.getPrice());
		if(existed==null) {
			cartItemRepository.save(c);
		}else {
			existed.setQuantity(c.getQuantity() + existed.getQuantity());
			cartItemRepository.save(existed);
		}
	}
	@Override
	public void setTotal() {
		List<CartItem> list = cartItemRepository.findAll();
		for (CartItem c : list) {
			c.setTotal(c.getQuantity()*c.getProduct().getPrice());
			cartItemRepository.save(c);
		}
	}
	@Override
	public void changeQuantity(Long id, Integer quantity) {
			CartItem c = cartItemRepository.getById(id);
			c.setQuantity(quantity);
			cartItemRepository.save(c);
	}
	
	@Override
	public List<CartItem> findAll() {
		return cartItemRepository.findAll();
	}

	@Override
	public CartItem getById(Long id) {
		return cartItemRepository.getById(id);
	}
	@Override
	public void deleteById(Long id) {
		cartItemRepository.deleteById(id);
	}

	@Override
	public double getTotal() {
		double total=0;
		List<CartItem> list = cartItemRepository.findAll();
		for (CartItem c : list) {
			total += c.getQuantity() * c.getProduct().getPrice();
		}
		return total;
	}
	
}
