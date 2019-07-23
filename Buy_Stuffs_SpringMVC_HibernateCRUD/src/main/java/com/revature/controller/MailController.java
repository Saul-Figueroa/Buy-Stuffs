package com.revature.controller;

import javax.mail.MessagingException;

import com.revature.mail.JavaMailUtil;

public class MailController {
	
	public static void main(String[] args) throws MessagingException {
		
		JavaMailUtil.sendMail("sauleff@gmail.com");
		
	}

}
