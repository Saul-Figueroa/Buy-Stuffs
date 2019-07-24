package com.revature.dao;

import com.revature.entity.Client;

public interface MailDAO {
	

	public Client findUserByEmail(String email);

	public Client findUserByResetToken(String resetToken);
	
	public void save(Client client);
}
