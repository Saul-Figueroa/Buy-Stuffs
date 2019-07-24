package com.revature.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.Client;

@Repository("userRepository")
public class MailDAOImpl implements MailDAO{
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Client findUserByEmail(String email) {
		System.out.println("Starting find by mail");
		Query query = sessionFactory.getCurrentSession().createQuery("from Client where email= :email");
		query.setParameter("email", email);
		System.out.println("Entring here DAO");
		Client client = (Client) query.getSingleResult();
		return client;	
	}

	@Override
	public Client findUserByResetToken(String resetToken) {
		
		System.out.println("Starting find by mail");
		Query query = sessionFactory.getCurrentSession().createQuery("from Client where resetToken= :resetToken");
		query.setParameter("resetToken", resetToken);
		System.out.println("Entring here DAO");
		Client client = (Client) query.getSingleResult();
		return client;	
	}

	@Override
	public void save(Client client) {
	
		sessionFactory.getCurrentSession().saveOrUpdate(client);
		System.out.println("User added successfully");
		
	}
	
//	public static void main(String[] args) {
//		//call find by email
//		UserDAOImpl call = new UserDAOImpl();
//		System.out.println(call.findUserByResetToken("3bc47d80-b7c2-4338-907c-c8669e68542a"));
//	}

}
