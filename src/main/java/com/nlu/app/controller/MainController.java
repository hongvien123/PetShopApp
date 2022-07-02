package com.nlu.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nlu.app.entity.CategoryEntity;
import com.nlu.app.entity.ProductEntity;
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
		List<ProductEntity> list1 = productService.getLastestProduct(date);
		model.addAttribute("list", list1);
		List<ProductEntity> sold = productService.getSellProduct(11);
		model.addAttribute("sold", sold);
		List<ProductEntity> discount = productService.getDiscountProduct(20);
		model.addAttribute("discount", discount);
		List<CategoryEntity> cate = categoryService.getAllCategory();
		model.addAttribute("cate", cate);
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
	
	@RequestMapping("register")
	public String register(Model model) {
		return "register";
	}
	@RequestMapping("forgotPassword")
	public String forgotPassword(Model model) {
		return "forgotPassword";
	}
}
