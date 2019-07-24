package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.MailDAOImpl;
import com.revature.entity.Client;

@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	
	private MailDAOImpl mailDaoImpl;

	@Override
	@Transactional
	public Client findUserByEmail(String email) {
		return mailDaoImpl.findUserByEmail(email);
	}

	@Override
	@Transactional
	public Client findUserByResetToken(String resetToken) {
		return mailDaoImpl.findUserByResetToken(resetToken);
	}

	@Override
	@Transactional
	public void save(Client client) {
		mailDaoImpl.save(client);
		
	}
	
//	public static void main(String[] args) {
//		//call find by email
//		System.out.println("Entering here");
//		
//		
//		System.out.println(findUserByEmail("SAULEFF@GMAIL.COM"));
//	}

}
