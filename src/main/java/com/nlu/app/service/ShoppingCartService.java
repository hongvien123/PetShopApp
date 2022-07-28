package com.nlu.app.service;

import java.util.List;

import com.nlu.app.entity.CartItem;
import com.nlu.app.entity.User;

public interface ShoppingCartService {

	List<CartItem> listCartItem(User user);

}
