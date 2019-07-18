package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/LoginController")
public class LoginController {
	
	@GetMapping("/")
	public String hello(Model model) {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value="logon", method=RequestMethod.GET)
	public ModelAndView hello(@RequestParam("uname") String username,
								@RequestParam("pass") String password) {
		return new ModelAndView("success", "result", "Welcome " + username + "!");
	}

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

}
