package com.revature.service;

import java.util.List;

import com.revature.entity.Client;
import com.revature.entity.User;

public interface ClientService {
	
	//Save and update	
	public void addClient(Client client);	
	public List<Client> getAllClients();
	public Client fetchClientById(int clientId);
//	public void deleteClientById(int clientId);
	public String viewHome(Client client);
	public Client login(String email, String password);
	public User findUserByEmail(String email);
	public User findUserByResetToken(String resetToken);
}
