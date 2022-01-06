package dao;

import exception.ApplicationException;
import pojo.UserPojo;

public interface UserDao {
	UserPojo register(UserPojo userPojo) throws ApplicationException;

	UserPojo validateUser(UserPojo userPojo) throws ApplicationException;

	void exitApplication();
}