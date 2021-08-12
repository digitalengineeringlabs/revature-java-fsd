package manager;

import common.model.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserManager {
	
	UserDao dao = new UserDaoImpl();

	public UserManager() {}
	
	public void create(User user) {
		dao.create(user);
	}
	
	public boolean login(String username, String password) {
		if(dao.getUser(username, password) != null) {
			return true;
		}
		return false;
	}

}
