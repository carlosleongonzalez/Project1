package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.UserDao;
import dao.UserJdbcDaoImpl;
import exception.ApplicationException;
import pojo.UserPojo;

public class UserServiceImpl implements UserService {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserJdbcDaoImpl();
	}

	@Override
	public UserPojo register(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered register() in service.");
		UserPojo returnUserPojo = this.userDao.register(userPojo);
		logger.info("Exited register() in service.");
		return returnUserPojo;
	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered validateUser() in service.");
		UserPojo returnUserPojo = this.userDao.validateUser(userPojo);
		logger.info("Exited validateUser() in service.");
		return returnUserPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		userDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}
}