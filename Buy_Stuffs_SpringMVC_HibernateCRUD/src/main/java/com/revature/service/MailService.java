package com.revature.service;

import com.revature.entity.Client;

public interface MailService {
	
	
	public Client findUserByEmail(String email);

	public Client findUserByResetToken(String resetToken);
	
	public void save(Client client);

}
