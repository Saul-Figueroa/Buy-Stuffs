package com.revature.controller;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.revature.entity.Client;
import com.revature.mail.JavaMailUtil;
import com.revature.service.MailService;

@Controller
@RequestMapping("/user")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	//Display login page
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView displayLoginPage() {
			return new  ModelAndView("login");
		}
		
	
	//Display forgot password page
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView displayForgotPasswordPage() {
		return new  ModelAndView("forgotPassword");
	}
//	
	//Process the submission from forgotPassword page
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String userEmail, HttpServletRequest request ) throws MessagingException {
		//Lookup user in the database by email
				System.out.println(userEmail);
				Client client = mailService.findUserByEmail(userEmail.toUpperCase());
				System.out.println("User information "+client);
				
		
		if (client == null) {
			modelAndView.addObject("errorMessage", "We didn't find an account for that email address" );
			modelAndView.setViewName("errorMessage");
			return modelAndView;
		}
		else {
		// Generate random 36-character string token for reset password
		client.setResetToken(UUID.randomUUID().toString());
		System.out.println("This is the token "+client.getResetToken());
		
		// Save token to database
		mailService.save(client);
		
		System.out.println("User values "+client);
		
		String appUrl = request.getScheme() + "://" + request.getServerName()+ ":8090/Buy_Stuffs/user/reset?token="+client.getResetToken();
		System.out.println("This is the URL "+appUrl);
		
		
		//Call the send mail boolean method
		if (JavaMailUtil.sendMail(client, appUrl)) {
			modelAndView.addObject("successMessage","A password reset link has been sent to " + client.getEmail());
			modelAndView.setViewName("successMessage");
			return modelAndView;
				}
		
		}
			
		
		modelAndView.setViewName("forgotPassword");
		return modelAndView;
		
	}
	
	//Display form to reset password
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token, HttpServletRequest request ) {
		
		Client clientToken = mailService.findUserByResetToken(token);
		System.out.println("Token information "+clientToken);
		
		 request.getSession().setAttribute("userToken", clientToken);
		 System.out.println("Requestinformation "+request.getSession().getAttribute("userToken"));
		

		if (!(clientToken == null)) { // Token found in DB
			modelAndView.addObject("resetToken", token);
			
			
		} else { // Token not found in DB
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
		}
		
		modelAndView.setViewName("resetPassword");
		return modelAndView;
	}
	
	
	
	// Process reset password form	
		@RequestMapping(value = "/reset", method = RequestMethod.POST)
		public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam String password, RedirectAttributes redir, HttpServletRequest request) {
			Client tokenClient = (Client) request.getSession().getAttribute("userToken");
			System.out.println("Request parameter "+tokenClient);
			System.out.println("Reset parameter "+tokenClient.getResetToken());
			
			// Find the user associated with the reset token
			Client client = mailService.findUserByResetToken(tokenClient.getResetToken());
			System.out.println("User information "+client);

			// This should always be non-null but we check just in case
			if (!(client == null)) {
				
				System.out.println("Changing the password");
				// Set new password    
	            client.setPassword(password);
	            
				// Set the reset token to null so it cannot be used again
				client.setResetToken(null);

				// Save user
				mailService.save(client);

				// In order to set a model attribute on a redirect, we must use
				// RedirectAttributes
				redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

				modelAndView.setViewName("redirect:http://localhost:4200/login");
				return modelAndView;
				
			} else {
				modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
				modelAndView.setViewName("resetPassword");	
			}
			
			return modelAndView;
	   }
		
		// Going to reset page without a token redirects to login page
		@ExceptionHandler(MissingServletRequestParameterException.class)
		public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
			return new ModelAndView("redirect:login");
		}
}









