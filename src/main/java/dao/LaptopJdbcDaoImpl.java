package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import exception.ApplicationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pojo.LaptopPojo;


public class LaptopJdbcDaoImpl implements LaptopDao {

	private static final Logger logger = LogManager.getLogger(LaptopJdbcDaoImpl.class);

	@Override
	public LaptopPojo addLaptop(LaptopPojo laptopPojo) throws ApplicationException {
		logger.info("Entered addLaptop() in dao.");

		// this bookPojo does not have a book id set in it.
		// set the book_removed to false
		laptopPojo.setLaptopRemoved(false);

		// jdbc steps 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();

			// fixed the code to return the generated book_id
			String query = "insert into laptop_details(laptop_model, laptop_brand, laptop_cost, laptop_removed, laptop_image)"
					+ "values('" + laptopPojo.getLaptopModel() + "','" + laptopPojo.getLaptopBrand() + "',"
					+ laptopPojo.getLaptopCost() + "," + laptopPojo.isLaptopRemoved() +",'"+laptopPojo.getLaptopImage()+"') returning laptop_id";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			laptopPojo.setId(rs.getInt(1));
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited addLaptop() in dao.");
		return laptopPojo;
	}

	@Override
	public LaptopPojo updateLaptop(LaptopPojo laptopPojo) throws ApplicationException {

		logger.info("Entered updateLaptop() in dao.");

		// jdbc step 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "update laptop_details set laptop_cost=" + laptopPojo.getLaptopCost() + " where laptop_id="
					+ laptopPojo.getId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited updateLaptop() in dao.");
		return laptopPojo;

	}

	@Override
	public boolean deleteLaptop(int laptopId) throws ApplicationException {

		logger.info("Entered deleteLaptop() in dao.");

		boolean flag = true;
		Connection conn = DBUtil.makeConnection();
		int rowsAffected = 0;
		try {
			Statement stmt = conn.createStatement();
			// here we are not going to do a hard delete, we are going
			// for a soft delete.
			String query = "update laptop_details set laptop_removed=true where laptop_id=" + laptopId;
			rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected);

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		if (rowsAffected == 0)
			flag = false;

		logger.info("Exited deleteLaptop() in dao.");
		return flag;
	}

	@Override
	public List<LaptopPojo> getAllLaptops() throws ApplicationException {
		logger.info("Entered getAllLaptops() in dao.");

		// create an empty collection which is going to hold all the records from the
		// database as pojo object
		List<LaptopPojo> allLaptopsStore = new ArrayList<LaptopPojo>();
		Connection conn = DBUtil.makeConnection();
		Statement stmt;

		try {

			stmt = conn.createStatement();

			String query = "select * from laptop_details where laptop_removed = false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// here as we iterate through the rs we put
				// each record in a pojo object and add it to the collection
				// and at the end we return the collection

				// as we iterate we are taking each record and storing it in a laptopPojo object
				LaptopPojo laptopPojo = new LaptopPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getBoolean(5), rs.getString(6));

				// add the laptopPojo object to a collection
				allLaptopsStore.add(laptopPojo);
			}

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllLaptops() in dao.");
		return allLaptopsStore;
	}

	@Override
	public LaptopPojo getALaptop(int laptopId) throws ApplicationException {
		logger.info("Entered getALaptop() in dao.");

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		LaptopPojo laptopPojo = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from laptop_details where laptop_id=" + laptopId + "and laptop_removed=false";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				laptopPojo = new LaptopPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getBoolean(5), rs.getString(6));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getALaptop() in dao.");
		return laptopPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

}