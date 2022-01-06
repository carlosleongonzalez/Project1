package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.LaptopJdbcDaoImpl;
import dao.ReimbursementDao;
import dao.ReimbursementJdbcDaoImpl;
import exception.ApplicationException;
import pojo.LaptopPojo;
import pojo.ReimbursementPojo;

public class ReimbursementServiceImpl implements ReimbursementService {
	
	private static final Logger logger = LogManager.getLogger(ReimbursementServiceImpl.class);
	
	ReimbursementDao reimbursementDao;
	
	public ReimbursementServiceImpl() {

//		this.laptopDao = new LaptopDaoImpl();
		this.reimbursementDao = new ReimbursementJdbcDaoImpl();
	}

	@Override
	public ReimbursementPojo addReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered addReimbursement() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.addReimbursement(reimbursementPojo);
		logger.info("Exited addReimbursement() in service.");
		return returnReimbursementPojo;
	}

	@Override
	public ReimbursementPojo updateReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered updateReimbursement() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.updateReimbursement(reimbursementPojo);
		logger.info("Exited updateReimbursement() in service.");
		return returnReimbursementPojo;
	}

	@Override
	public boolean deleteReimbursement(int reimbursementId) throws ApplicationException {
		logger.info("Entered deleteReimbursement() in service.");
		boolean returnFlag = this.reimbursementDao.deleteReimbursement(reimbursementId);
		logger.info("Exited deleteReimbursement() in service.");
		return returnFlag;
	}

	@Override
	public List<ReimbursementPojo> getAllReimbursements() throws ApplicationException {
		logger.info("Entered getAllReimbursements() in service.");
		List<ReimbursementPojo> allReimbursements = this.reimbursementDao.getAllReimbursements();
		logger.info("Exited getAllLaptops() in service.");
		return allReimbursements;
	}

	@Override
	public ReimbursementPojo getAReimbursement(int reimbursementId) throws ApplicationException {
		logger.info("Entered getAReimbursement() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.getAReimbursement(reimbursementId);
		logger.info("Exited getAReimbursement() in service.");
		return returnReimbursementPojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		reimbursementDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
		
	}

}
