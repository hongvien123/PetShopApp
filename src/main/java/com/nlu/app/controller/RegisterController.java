package com.nlu.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlu.app.entity.UserEntity;
import com.nlu.app.service.UserService;
import com.nlu.app.validator.UserValidator;

@Controller
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator userValidator;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	@RequestMapping(value = "register", method = RequestMethod.GET)
//	public ModelAndView showRegister() {
//		ModelAndView model = new ModelAndView();
//		UserEntity user = new UserEntity();
//		model.addObject(user);
//		model.setViewName("register");
//		
//		return model;
//	}
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegister() {

		
		return "register";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView register(@Valid UserEntity userEntity, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		UserEntity user = userService.findByUserName(userEntity.getUsername());
		
		if (user != null) {
			bindingResult.rejectValue("username","error.user", "Username already exists!");
		}
        if (bindingResult.hasErrors()) {
        	model.setViewName("register");
           
        }else {
        	userService.saveUser(user);
        	model.addObject("msg", "User has been registered successfully!");
        	model.addObject("user", new UserEntity());
        	model.setViewName("login");
        }

        

        return model;
	}


}
