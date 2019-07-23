package com.revature.dao;

import com.revature.entity.User;

public interface UserDAO {
	

	public User findUserByEmail(String email);

	public User findUserByResetToken(String resetToken);
	
	public void save(User user);
}
