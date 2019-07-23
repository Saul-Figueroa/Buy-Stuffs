package com.revature.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.Item;
import com.revature.entity.User;

@Repository("userRepository")
public class UserDAOImpl implements UserDAO{
//	private static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
//	
//	@Autowired
//	SessionFactory sessionFactory;
//
//	@Override
//	public User findUserByEmail(String email) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		User user = currentSession.get(User.class, email);
//		LOGGER.trace("Getting user by email "+user);
//		return user;	
//	}
//
//	@Override
//	public User findUserByResetToken(String resetToken) {
//		
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		User user = currentSession.get(User.class, resetToken);
//		LOGGER.trace("Getting user by reset token "+user);
//		return user;	
//	}
//
//	@Override
//	public void save(User user) {
//	
//		sessionFactory.getCurrentSession().saveOrUpdate(user);
//		LOGGER.trace("User added successfully");
//		
//	}

}
