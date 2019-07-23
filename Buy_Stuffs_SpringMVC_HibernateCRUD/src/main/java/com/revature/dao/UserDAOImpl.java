package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.User;

@Repository("userRepository")
public class UserDAOImpl implements UserDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User findUserByEmail(String email) {
		System.out.println("Starting find by mail");
		Query query = sessionFactory.getCurrentSession().createQuery("from User where email= :email");
		query.setParameter("email", email);
		System.out.println("Entring here DAO");
		User user = (User) query.getSingleResult();
		return user;	
	}

	@Override
	public User findUserByResetToken(String resetToken) {
		
		System.out.println("Starting find by mail");
		Query query = sessionFactory.getCurrentSession().createQuery("from User where resetToken= :resetToken");
		query.setParameter("resetToken", resetToken);
		System.out.println("Entring here DAO");
		User user = (User) query.getSingleResult();
		return user;	
	}

	@Override
	public void save(User user) {
	
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		System.out.println("User added successfully");
		
	}
	
//	public static void main(String[] args) {
//		//call find by email
//		UserDAOImpl call = new UserDAOImpl();
//		System.out.println(call.findUserByResetToken("3bc47d80-b7c2-4338-907c-c8669e68542a"));
//	}

}
