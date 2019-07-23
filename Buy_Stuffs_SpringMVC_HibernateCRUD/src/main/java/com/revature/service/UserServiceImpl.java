package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDAOImpl;
import com.revature.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	
	private UserDAOImpl userDaoImpl;

	@Override
	@Transactional
	public User findUserByEmail(String email) {
		return userDaoImpl.findUserByEmail(email);
	}

	@Override
	@Transactional
	public User findUserByResetToken(String resetToken) {
		return userDaoImpl.findUserByResetToken(resetToken);
	}

	@Override
	@Transactional
	public void save(User user) {
		userDaoImpl.save(user);
		
	}
	
//	public static void main(String[] args) {
//		//call find by email
//		System.out.println("Entering here");
//		
//		
//		System.out.println(findUserByEmail("SAULEFF@GMAIL.COM"));
//	}

}
