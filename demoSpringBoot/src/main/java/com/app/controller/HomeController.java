package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("---home-----controller");
	}
	
	@GetMapping("/")
	public String Indexshow() {
		System.out.println("index page loaded...............");
		return "index";
	}

}
