package com.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("----------home controller invoke-----------");
	}
	
	@RequestMapping("/")
	public String showHome() {
		System.out.println("index controlller done--------------");
		return "index";
	}

	@RequestMapping("/login")
	public String showabout() {
		System.out.println("login controlller done--------------");
		return "login";
	}

	@RequestMapping("/register")
	public String showaRegister() {
		System.out.println("register controlller done--------------");
		return "register";
	}
}
