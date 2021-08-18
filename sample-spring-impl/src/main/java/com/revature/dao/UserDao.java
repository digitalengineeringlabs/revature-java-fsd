package com.revature.dao;

import com.revature.model.User;

public interface UserDao {
	
	public User findByUsernameAndPassword(String username, String password);

}
