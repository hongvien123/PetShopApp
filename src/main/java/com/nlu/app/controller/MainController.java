package com.nlu.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
		 @RequestMapping("/home")
		  public String index(Model model) {
		    return "index";
		  }

}
