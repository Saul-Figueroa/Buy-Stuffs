package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Client;
import com.revature.service.ClientService;

//	@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	// Add new client
	@PostMapping("/clients")
	public Client addClient(@RequestBody Client client) {

		clientService.addClient(client);
		return client;

	}

	// Get all clients
	@GetMapping("/clients")
	public List<Client> getAllClients() {

		System.out.println("Entered list clients");
		List<Client> clients = clientService.getAllClients();

		System.out.println("List: " + clients);

		if (clients == null) {
			return null;
		}

		return clients;
	}

	// Get client by id
	@GetMapping("/clients/{id}")
	public Client findClientById(@PathVariable int id) {
		Client client = clientService.fetchClientById(id);
		System.out.println("Client " + client);

		return client;

	}

//	// Delete client
//	@RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
//	public String deleteClient(@PathVariable("id") int id) {
//
//		clientService.deleteClientById(id);
//		System.out.println("Client deleted id " + id);
//
//		return "Client deleted successfully";
//
//	}

	@RequestMapping(value = "/clients", method = RequestMethod.PUT)
	public String updateClient(@RequestBody Client client) {

		// Is the same logic as add client (save or update)
		clientService.addClient(client);
		return "Client updated successfully";

	}

}
