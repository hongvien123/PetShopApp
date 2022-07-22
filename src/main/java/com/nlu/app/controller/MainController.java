package com.nlu.app.controller;

import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nlu.app.entity.Category;
import com.nlu.app.entity.Product;
import com.nlu.app.service.CategoryService;
import com.nlu.app.service.ProductService;

@Controller
public class MainController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/home")
	public String index(Model model) throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-DD");
		Date date = s.parse("2022-06-20");
		List<Product> list1 = productService.findByDateGreaterThan(date);
		List<Product> list2 = productService.findByDiscountGreaterThan(0);
		List<Product> list3 = productService.findBySoldGreaterThan(10);
		List<Category> list0 = categoryService.findAll();
		
		model.addAttribute("list0", list0);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);

		return "index";
	}
	@RequestMapping("shop")
	public String shop(Model model) {
		return "shop";
	}
	@RequestMapping("blog")
	public String blog(Model model) {
		return "blog";
	}
	@RequestMapping("cart")
	public String cart(Model model) {
		return "cart";
	}
	@RequestMapping("contact")
	public String contact(Model model) {
		return "contact";
	}
	@RequestMapping("checkout")
	public String checkout(Model model) {
		return "checkout";
	}
	@RequestMapping("changePassword")
	public String changePassword(Model model) {
		return "changePassword";
	}
	@RequestMapping("detail")
	public String detail(Model model) {
		return "detail";
	}
	@RequestMapping("userInfo")
	public String userInfo(Model model) {
		return "userInfo";
	}
	@RequestMapping("login")
	public String login(Model model) {
		return "login";
	}
	@RequestMapping("register")
	public String register(Model model) {
		return "register";
	}
	@RequestMapping("forgotPassword")
	public String forgotPassword(Model model) {
		return "forgotPassword";
	}
	@RequestMapping("search")
	public String search(Model model) {
		return "search";
	}
	
}
