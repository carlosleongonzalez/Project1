package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import pojo.LaptopPojo;
import pojo.ReimbursementPojo;

public class ReimbursementJdbcDaoImpl implements ReimbursementDao{
	
	private static final Logger logger = LogManager.getLogger(ReimbursementJdbcDaoImpl.class);

	@Override
	public ReimbursementPojo addReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered addReimbursement() in dao.");

		// this reimbursementPojo does not have a reimbursement id set in it.
		// set the reimbursemet_removed to false
		reimbursementPojo.setReimbursementRemoved(false);

		// jdbc steps 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();

			// fixed the code to return the generated book_id
			String query = "insert into reimbursement_details(reimbursement_date, reimbursement_amount, reimbursement_status, reimbursement_worker, reimbursement_removed)"
					+ "values('" + reimbursementPojo.getReimbursementDate() + "'," + reimbursementPojo.getReimbursementAmount() + ",'"
					+ reimbursementPojo.getReimbursementStatus() + "','" + reimbursementPojo.getReimbursementWorker() + "'," + reimbursementPojo.isReimbursementRemoved()+ ") returning reimbursement_id";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			reimbursementPojo.setReimbursementId(rs.getInt(1));
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited addReimbursement() in dao.");
		return reimbursementPojo;
	}

	

	@Override
	public ReimbursementPojo updateReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered updateReimbursement() in dao.");

		// jdbc step 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "update reimbursement_details set reimbursement_amount=" + reimbursementPojo.getReimbursementAmount() + " where reimbursement_id="
					+ reimbursementPojo.getReimbursementId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited updateReimbursement() in dao.");
		return reimbursementPojo;

	}

	@Override
	public boolean deleteReimbursement(int reimbursementId) throws ApplicationException {
		
		logger.info("Entered deleteReimbursement() in dao.");

		boolean flag = true;
		Connection conn = DBUtil.makeConnection();
		int rowsAffected = 0;
		try {
			Statement stmt = conn.createStatement();
			// here we are not going to do a hard delete, we are going
			// for a soft delete.
			String query = "update reimbursement_details set reimbursement_removed=true where reimbursement_id=" + reimbursementId;
			rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected);

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		if (rowsAffected == 0)
			flag = false;

		logger.info("Exited deleteReimbursement() in dao.");
		return flag;
	}

	@Override
	public List<ReimbursementPojo> getAllReimbursements() throws ApplicationException {
		
		logger.info("Entered getAllReimbursements() in dao.");

		// create an empty collection which is going to hold all the records from the
		// database as pojo object
		List<ReimbursementPojo> allReimbursementsStore = new ArrayList<ReimbursementPojo>();
		Connection conn = DBUtil.makeConnection();
		Statement stmt;

		try {

			stmt = conn.createStatement();

			String query = "select * from reimbursement_details where reimbursement_removed = false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// here as we iterate through the rs we put
				// each record in a pojo object and add it to the collection
				// and at the end we return the collection

				// as we iterate we are taking each record and storing it in a laptopPojo object
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getBoolean(6));

				// add the laptopPojo object to a collection
				allReimbursementsStore.add(reimbursementPojo);
			}

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllReimbursements() in dao.");
		return allReimbursementsStore;
	}

	@Override
	public ReimbursementPojo getAReimbursement(int reimbursementId) throws ApplicationException {
		logger.info("Entered getAReimbursement() in dao.");

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		ReimbursementPojo reimbursementPojo = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where reimbursement_id=" + reimbursementId + "and reimbursement_removed=false";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getBoolean(6));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAReimbursement() in dao.");
		return reimbursementPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
		
	}
	
	

}
