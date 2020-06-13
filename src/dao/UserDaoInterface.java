package dao;

import model.user;

public interface UserDaoInterface {
	
	int signUp(user user) throws ClassNotFoundException;
	boolean loginUser(user user);

}
