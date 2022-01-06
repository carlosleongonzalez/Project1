package dao;

import java.util.List;

import exception.ApplicationException;
//import pojo.LaptopPojo;
//import pojo.ReimbursementPojo;
import pojo.ReimbursementPojo;

public interface ReimbursementDao {
	
	ReimbursementPojo addReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException;

	ReimbursementPojo updateReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException;

	boolean deleteReimbursement(int reimbursementId) throws ApplicationException;

	List<ReimbursementPojo> getAllReimbursements() throws ApplicationException;

	ReimbursementPojo getAReimbursement(int ReimbursementId) throws ApplicationException;

	void exitApplication();

}
