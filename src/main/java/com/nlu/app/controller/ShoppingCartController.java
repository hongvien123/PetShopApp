package com.nlu.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nlu.app.service.ShoppingCartService;
import com.nlu.app.service.UserService;

@Controller
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	UserService userService;
	
//	@GetMapping("/cart")
//	public String showShoppingCart(Model model,
//			@AuthenticationPrincipal Authentication authentication) {
//		
//		return "cart";
//	}
	

}
