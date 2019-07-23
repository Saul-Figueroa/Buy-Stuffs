package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.User;

@Repository("userRepository")
public class UserDAOImpl implements UserDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User findUserByEmail(String email) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		User user = currentSession.get(User.class, email);
		System.out.println("Getting user by email "+user);
		return user;	
	}

	@Override
	public User findUserByResetToken(String resetToken) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		User user = currentSession.get(User.class, resetToken);
		System.out.println("Getting user by reset token "+user);
		return user;	
	}

	@Override
	public void save(User user) {
	
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		System.out.println("User added successfully");
		
	}

}
