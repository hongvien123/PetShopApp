package com.nlu.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nlu.app.service.UserService;

@Controller
public class LoginController {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String showLogin(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
		if (userService.checkLogin(username, password)) {
			return "index";
		}else {
		
		model.addAttribute("error", "Username or password not exist!");
		
		
		return "login";}
	}
	

}
