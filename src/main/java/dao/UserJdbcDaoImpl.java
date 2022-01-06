package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import pojo.UserPojo;

public class UserJdbcDaoImpl implements UserDao {

	private static final Logger logger = LogManager.getLogger(UserJdbcDaoImpl.class);

	@Override
	public UserPojo register(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered register() in dao.");

		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into user_details(user_password, user_first_name, user_last_name, user_type, user_removed)"
					+ "values('" + userPojo.getUserPassword() + "','" + userPojo.getUserFirstName() + "','"
					+ userPojo.getUserLastName() + "','" + userPojo.getUserType() + "'," + userPojo.isUserRemoved()
					+ ") returning user_id";

			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			userPojo.setUserId(rs.getInt(1));
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited register() in dao.");
		return userPojo;
	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered validateUser() in dao.");

		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from user_details where user_id=" + userPojo.getUserId() + " and user_password='"
					+ userPojo.getUserPassword() + "' and user_removed=false";

			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				userPojo.setUserFirstName(rs.getString(3));
				userPojo.setUserLastName(rs.getString(4));
				userPojo.setUserType(rs.getString(5));
				userPojo.setUserRemoved(rs.getBoolean(6));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited validateUser() in dao.");
		return userPojo;
	}

	@Override
	public void exitApplication() {
		DBUtil.closeConnection();
	}

}