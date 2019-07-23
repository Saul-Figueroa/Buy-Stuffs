package com.revature.controller;

import java.util.Map;
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

import com.revature.entity.User;
import com.revature.mail.JavaMailUtil;
import com.revature.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
		
		User user = userService.findUserByEmail(userEmail);
		
		if (user == null) {
			modelAndView.addObject("errorMessage", "We didn't find an account for that email addredd" );
		}
		else {
		// Generate random 36-character string token for reset password
		user.setResetToken(UUID.randomUUID().toString());
		System.out.println("This is the token "+user.getResetToken());
		
		// Save token to database
		userService.save(user);
		
		System.out.println("User values "+user);
		
		String appUrl = request.getScheme() + "://" + request.getServerName()+ "/reset?token="+user.getResetToken();
		System.out.println("This is the URL "+appUrl);
		
		
		//Call the send mail boolean method
		if (JavaMailUtil.sendMail(user, appUrl)) {
			modelAndView.addObject("successMessage","A password reset link has been sent to " + user.getEmail());
				}
		
		}
		
		
		modelAndView.setViewName("forgotPassword");
		return modelAndView;
		
	}
	
	//Display form to reset password
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
		
		User user = userService.findUserByResetToken(token);

		if (!(user == null)) { // Token found in DB
			modelAndView.addObject("resetToken", token);
		} else { // Token not found in DB
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
		}

		modelAndView.setViewName("resetPassword");
		return modelAndView;
	}
	
	
	// Process reset password form
		@RequestMapping(value = "/reset", method = RequestMethod.POST)
		public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

			// Find the user associated with the reset token
			User user = userService.findUserByResetToken(requestParams.get("token"));

			// This should always be non-null but we check just in case
			if (!(user == null)) {
				
	 
				// Set new password    
	            user.setPassword(requestParams.get("password"));
	            
				// Set the reset token to null so it cannot be used again
				user.setResetToken(null);

				// Save user
				userService.save(user);

				// In order to set a model attribute on a redirect, we must use
				// RedirectAttributes
				redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

				modelAndView.setViewName("redirect:login");
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









