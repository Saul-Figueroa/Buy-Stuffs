package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		clientDAO.saveClient(client);
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

	@Override
	public void viewHome(Client client, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (client.getRole().equals("MANAGER")) {
			response.sendRedirect("http://localhost:4200/homeManager");
//			return "managerHome";
		} else if (client.getRole().equals("VENDOR")) {
			response.sendRedirect("http://localhost:4200/homeVendor");
//			return "vendorHome";
		}
		response.sendRedirect("http://localhost:4200/homeCustomer");
//		return "customerHome";
	}

	@Override
	@Transactional
	public Client login(String email, String password) {
//		Code to log in here
		System.out.println("Searching for client with login parameters: " + email + ", " + password);
		List<Client> clients = clientDAO.getAllClients();
		for (Client client : clients) {
			if (client.getEmail().equals(email) && client.getPassword().equals(password)) {
				System.out.println("Client found.");
				return client;
			}
		}
		System.out.println("Client not found.");
		return null;
	}

	
//	@Override
//	@Transactional
//	public void deleteClientById(int clientId) {
//		clientDAO.deleteClientById(clientId);
//	}

}
