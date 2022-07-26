package com.nlu.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
//model
	@ModelAttribute("categories")
	public List<Category> getAllCategory(Model model) {
		List<Category> list = categoryService.findAll();
		return list;
	}
	@ModelAttribute("products")
	public List<Product> getAllProduct(Model model) {
		List<Product> list = productService.findAll();
		return list;
	}
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("dog", "dog");
		model.addAttribute("cat", "cat");
	}
	
//hander
	@RequestMapping("/home")
	public String index(Model model) throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-DD");
		Date date = s.parse("2022-06-20");
		List<Product> list1 = productService.findByDateGreaterThan(date);
		List<Product> list2 = productService.findByDiscountGreaterThan(0);
		List<Product> list3 = productService.findBySoldGreaterThan(10);

		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		model.addAttribute("dog", "dog");
		model.addAttribute("cat", "cat");

		return "index";
	}

	@GetMapping(value = "/search")
	public String search(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
		List<Product> list = null;
		if (StringUtils.hasText(keyword)) {
			list = productService.findByNameContaining(keyword);
		} else {
			list = productService.findAll();
		}
		
		model.addAttribute("list", list);
		return "search";
	}

	@GetMapping(value = {"/categories/{id}"})
	public String category(Model model, @PathVariable Long id) {
		List<Product> list = productService.findByCategoryId(id);
		model.addAttribute("list", list);
		return "search";
	}

	@RequestMapping("shop/{object}")
	public String shop(Model model, @PathVariable String object) {
		List<Product> list1 = productService.findByObjectAndDiscountGreaterThan(object, 0);
		List<Product> list2 = productService.findByObjectAndSoldGreaterThan(object, 10);
		List<Product> list3 = productService.findByObject(object);
		
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);

		return "shop";
	}
	@GetMapping(value = {"/product/{id}"})
	public String detail(Model model, @PathVariable Long id) {
		Product product = productService.getById(id);
		model.addAttribute("product", product);
		return "detail";
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

}
