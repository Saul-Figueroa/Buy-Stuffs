package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.Client;

@Repository("ClientDAO")
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addClient(Client client) {
		sessionFactory.getCurrentSession().saveOrUpdate(client);
		System.out.println("Client added succesfully");
		
	}

	@Override
	public List<Client> getAllClients() {
		List<Client> clientList = new ArrayList<>();

		
		Query query = sessionFactory.getCurrentSession().createQuery("from Client");
		query.setMaxResults(100);
		clientList = (ArrayList<Client>) query.list();
		System.out.println("List in DAO "+clientList);
		
		
		return clientList;
	}

	@Override
	public Client fetchClientById(int clientId) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("Book in DAO "+clientId);
		Client client = currentSession.get(Client.class, clientId);
		return client;	
	}

//	@Override
//	public void deleteClientById(int clientId) {
//		Session session = sessionFactory.getCurrentSession();
//		Client client = session.byId(Client.class).load(clientId);
//		System.out.println("Delete called from dao "+client);
//		session.delete(client);
//	}

}
