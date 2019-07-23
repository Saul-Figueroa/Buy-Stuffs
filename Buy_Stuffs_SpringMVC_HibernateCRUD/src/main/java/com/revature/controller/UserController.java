package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private EmailService emailService;
//	
	
//	//Display login page
//		@RequestMapping(value = "/login", method = RequestMethod.GET)
//		public ModelAndView displayLoginPage() {
//			return new  ModelAndView("login");
//		}
//	
//	//Display forgot password page
//	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
//	public ModelAndView displayForgotPasswordPage() {
//		return new  ModelAndView("forgotPassword");
//	}
//	
//	//Process the submission from forgotPassword page
//	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
//	public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String userEmail, HttpServletRequest request ) {
//		
//		//Lookup user in the database by email
//		
//		User user = userService.findUserByEmail(userEmail);
//		
//		if (user == null) {
//			modelAndView.addObject("errorMessage", "We didn't find an account for that email addredd" );
//		}
//		else {
//		// Generate random 36-character string token for reset password
//		user.setResetToken(UUID.randomUUID().toString());
//		
//		// Save token to database
//		userService.save(user);
//		
//		System.out.println("User values "+user);
//		
//		String appUrl = request.getScheme() + "://" + request.getServerName();
//		
//		
//		//Email message
//		SimpleMailMessage passwordResetEmail =  new SimpleMailMessage();
//		passwordResetEmail.setFrom("buy.stuffs2019@gmail.com");
//		passwordResetEmail.setTo(user.getEmail());
//		passwordResetEmail.setSubject("Password Reset Request");
//		passwordResetEmail.setText("To reset your password, click the link below:\n"+ appUrl + "/reset?token="+user.getResetToken());
//		
//		System.out.println("Sending mail...");
//		emailService.sendMail(passwordResetEmail);
//		
//		//Add success message to the view
//		modelAndView.addObject("successMessage","A password reset link has been sent to " + userEmail);
//		}
//		
//		
//		modelAndView.setViewName("forgotPassword");
//		return modelAndView;
//		
//	}
//	
//	//Display form to reset password
//	@RequestMapping(value = "/reset", method = RequestMethod.GET)
//	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
//		
//		User user = userService.findUserByResetToken(token);
//
//		if (!(user == null)) { // Token found in DB
//			modelAndView.addObject("resetToken", token);
//		} else { // Token not found in DB
//			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
//		}
//
//		modelAndView.setViewName("resetPassword");
//		return modelAndView;
//	}
//	
//	
//	// Process reset password form
//		@RequestMapping(value = "/reset", method = RequestMethod.POST)
//		public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
//
//			// Find the user associated with the reset token
//			User user = userService.findUserByResetToken(requestParams.get("token"));
//
//			// This should always be non-null but we check just in case
//			if (!(user == null)) {
//				
//	 
//				// Set new password    
//	            user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));
//	            
//				// Set the reset token to null so it cannot be used again
//				user.setResetToken(null);
//
//				// Save user
//				userService.save(user);
//
//				// In order to set a model attribute on a redirect, we must use
//				// RedirectAttributes
//				redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");
//
//				modelAndView.setViewName("redirect:login");
//				return modelAndView;
//				
//			} else {
//				modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
//				modelAndView.setViewName("resetPassword");	
//			}
//			
//			return modelAndView;
//	   }
//		
//		// Going to reset page without a token redirects to login page
//		@ExceptionHandler(MissingServletRequestParameterException.class)
//		public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
//			return new ModelAndView("redirect:login");
//		}
}









