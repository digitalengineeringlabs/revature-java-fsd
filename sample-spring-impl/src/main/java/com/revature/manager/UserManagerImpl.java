package com.revature.manager;

import com.revature.dao.UserDao;
import com.revature.model.User;

public class UserManagerImpl implements UserManager {
	
	private String role;
	private User user;
	
	private UserDao userDao;

	public UserManagerImpl() {}
	
	public UserManagerImpl(String role) {
		this.role = role;
	}

	public boolean login(String username, String password) {
		System.out.println("role in manager: "+this.role);
		System.out.println("user name: "+this.user.getName());
		if(userDao.findByUsernameAndPassword(username, password) != null)
			return true;
		return false;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

//	public void setRole(String role) {
//		this.role = role;
//	}

	public void load() {
		System.out.println("init called");
		
	}

	public void destroy() {
		System.out.println("destrory called");
	}

}
