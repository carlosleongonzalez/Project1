package service;

import exception.ApplicationException;
import pojo.UserPojo;

public interface UserService {
	UserPojo register(UserPojo userPojo) throws ApplicationException;

	UserPojo validateUser(UserPojo userPojo) throws ApplicationException;

	void exitApplication();
}