package com.nlu.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nlu.app.entity.CartItem;
import com.nlu.app.entity.Category;
import com.nlu.app.entity.Product;
import com.nlu.app.entity.User;
import com.nlu.app.service.CategoryService;
import com.nlu.app.service.ProductService;
import com.nlu.app.service.ShoppingCartService;
import com.nlu.app.service.UserService;

@Controller
public class MainController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	ShoppingCartService shoppingCartService;
		
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
	@ModelAttribute
	public void addAttributes1(Model model) {
		List<CartItem> list = shoppingCartService.findAll();
		model.addAttribute("list", list);
		model.addAttribute("size", list.size());
		model.addAttribute("total", shoppingCartService.getTotal());

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
	
//	@GetMapping("search")
//	public String search(Model model, @RequestParam(name = "name", required = false) String name,
//			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
//		
//		int currentPage = page.orElse(1); //gia tri mac dinh la 1
//		int pageSize = size.orElse(8); //so san pham tren 1 trang
//		//tao ra doi tuong pageable
//		Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("name"));
//		Page<Product> resultPage = null;
//		
//		if (StringUtils.hasText(name)) { //keyword duoc truyen vao
//			resultPage = productService.findByNameContaining(name, pageable);
//			model.addAttribute("name", name);
//		} 
//		else { //keyword khong duoc truyen vao
//			resultPage = productService.findAll(pageable);
//		}
//		//tinh toan so trang hien thi tren view
//		int totalPages = resultPage.getTotalPages();
//		if(totalPages>0) {
//			int start = Math.max(1, currentPage-2);
//			int end = Math.min(currentPage+2, totalPages);
//			if(totalPages>5) {
//				if(end == totalPages) start = end-5;
//				else if(start == 1) end = start+5;
//			}
//		List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
//				.boxed()
//				.collect(Collectors.toList());
//		model.addAttribute("pageNumbers", pageNumbers);
//
//		}
//		model.addAttribute("productPage", resultPage);
//		return "search";
//	}

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
		List<CartItem> list = shoppingCartService.findAll();
		model.addAttribute("list", list);
		model.addAttribute("total", shoppingCartService.getTotal());
		shoppingCartService.setTotal();

		return "cart";
	}
	@GetMapping("/add/{id}")
	public String showShoppingCart(Model model, @PathVariable Long id) {
		shoppingCartService.addCartItem(id);
		List<CartItem> list = shoppingCartService.findAll();
		model.addAttribute("list", list);
		shoppingCartService.setTotal();

		return "redirect:/cart";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteItem(Model model, @PathVariable Long id) {
		shoppingCartService.deleteById(id);
		return "redirect:/cart";
	}

	@GetMapping("/update")
	public String update(Model model) {
//		int q = Integer.parseInt(quantity);
//		shoppingCartService.setQuantity(q);
		List<CartItem> list = shoppingCartService.findAll();
		model.addAttribute("list", list);
		model.addAttribute("total", shoppingCartService.getTotal());
		shoppingCartService.setTotal();

		return "redirect:/cart";
	}
	@RequestMapping("/update/{id}")
	public String updateItem(Model model, @PathVariable Long id, @RequestParam(name = "quantity", required = false) Integer quantity){
		shoppingCartService.changeQuantity(id,quantity);

		return "redirect:/cart";
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
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST )
	public String changePassword(Model model,@RequestParam("username") String username, @RequestParam("newpass1") String newpass1, @RequestParam("newpass2") String newpass2, HttpSession  session) {
//		if (newpass1==newpass2) {
//			userService.setPasswordByUsername(username, newpass2);
//			
//			
//			return "redirect:/login";
//			
//		}else {
//			model.addAttribute("error", "New password does not match the reconfirm password");
			return "changePassword";
//		}
	}
	@RequestMapping("userInfo")
	public String userInfo(Model model) {
		return "userInfo";
	}
	@RequestMapping(value = "/userInfo", method = RequestMethod.POST)
	public String userInfo(Model model,@RequestParam("username") String username, @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address, HttpSession  session) {
		
		User userEntity = (User) session.getAttribute("user");
		userEntity.setFistname(firstname);userEntity.setLastname(lastname);
		userEntity.setAddress(address);userEntity.setPhoneNumber(phoneNumber);
		userService.saveUser(userEntity);;
		return "redirect:/home";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String showLogin(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		
		if (userService.checkLogin(username, password)) {
			User user = new User(username, password);
			session.setAttribute("user", user);
			return "redirect:/home";
		}else {
		
		model.addAttribute("error", "Username or password not exist!");
		
		
		return "login";}
	}
	

	@RequestMapping("register")
	public String register(Model model) {
		return "register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("passwordConfirm") String passwordConfirm, Model model, HttpSession session) {
		if (email.equals(userService.findByEmail(email).getEmail())) {
			model.addAttribute("error", "Email exist!");
			return "register";
		}
		else if (username.equals(userService.findByUserName(username).getUsername())) {
			model.addAttribute("error", "Username exist!");
			return "register";
		}
		else if (password!=passwordConfirm) {
			model.addAttribute("error", "Password is not the same password confirm!");
			return "register";
		}
		
		
		User user = new User(username, password, passwordConfirm, email);
		session.setAttribute("user", user);
		userService.saveUser(user);
		
		return "redirect:/home";
		
		
		
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping("forgotPassword")
	public String forgotPassword(Model model) {
		return "forgotPassword";
	}

}
