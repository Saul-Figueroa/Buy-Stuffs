package com.revature.dao;

import java.util.List;

import com.revature.entity.Client;

public interface ClientDAO {
	
//Save and update	
public void addClient(Client client);	
public List<Client> getAllClients();
public Client fetchClientById(int clientId);
//public void deleteClientById(int clientId);




}