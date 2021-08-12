package dao;

import common.model.User;

public interface UserDao {

	public void create(User user);
	public User getUser(String username, String password);

}
