package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ClientDAOImpl;
import com.revature.entity.Client;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientDAOImpl clientDAO;

	@Override
	@Transactional
	public void addClient(Client client) {
		clientDAO.addClient(client);
	}

	@Override
	@Transactional
	public List<Client> getAllClients() {
		List<Client> clients = clientDAO.getAllClients();		
		return clients;
	}

	@Override
	@Transactional
	public Client fetchClientById(int clientId) {
		Client client = clientDAO.fetchClientById(clientId);
		return client;
	}

//	@Override
//	@Transactional
//	public void deleteClientById(int clientId) {
//		clientDAO.deleteClientById(clientId);
//	}
	
	

}
