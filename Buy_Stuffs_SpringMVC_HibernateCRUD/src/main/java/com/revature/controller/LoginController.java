package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.revature.entity.Client;
import com.revature.service.ClientService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/LoginController") //Instead of "/LoginController", but they'll go to Login if attribute is not set
@SessionAttributes("loggedClient")
public class LoginController {
	
	@Autowired
	ClientService clientService;
	
//	@GetMapping("/")
//	public String hello(Model model) {
//		return "index";
//	}

//	Not sure if works
	@ModelAttribute("loggedClient")
	public Client client() {
		return new Client();
	}
	
	@GetMapping("/viewHome")
	public String home(Model model, @ModelAttribute("loggedClient") Client client, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (client.getFirstName() != null) {
			clientService.viewHome(client, request, response);
		}
//		request.getRequestDispatcher("login").forward(request, response);
		return "login";
	}
	
	@GetMapping("/login")
	public String login(Model model, @ModelAttribute("loggedClient") Client client, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (client.getFirstName() != null) {
			clientService.viewHome(client, request, response);
		}
		return "login";
	}
	
	@RequestMapping(value="logon", method=RequestMethod.POST)
	public String logon(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model, @ModelAttribute("loggedClient") Client client, HttpServletRequest request, HttpServletResponse response) throws IOException {
		client = clientService.login(email, password);
		if (client != null) {
			model.addAttribute("loggedClient", client);
		} else {
//			return new ModelAndView("login", "result", "Unsuccessful login");
			return "login";
		}
//		return new ModelAndView(this.home(model, client), "loggedClient", client);
		return this.home(model, client, request, response);
//		"success", "result", "Welcome " + username + "!"
	}
	
	@GetMapping("/logout")
	public void logout(Model model, @ModelAttribute("loggedClient") Client client, SessionStatus session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (client.getFirstName() != null) {
			session.setComplete();
		}
		response.sendRedirect("http://localhost:4200");
//		request.getRequestDispatcher("http://localhost:4200").forward(request, response);
//		return "logout";
	}

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

}
