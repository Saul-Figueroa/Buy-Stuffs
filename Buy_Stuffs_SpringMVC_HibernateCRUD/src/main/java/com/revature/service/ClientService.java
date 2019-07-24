package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.entity.Client;

public interface ClientService {
	
	//Save and update	
	public void addClient(Client client);	
	public List<Client> getAllClients();
	public Client fetchClientById(int clientId);
//	public void deleteClientById(int clientId);
	public void viewHome(Client client, HttpServletRequest request, HttpServletResponse response) throws IOException;
	public Client login(String email, String password);
	
}
