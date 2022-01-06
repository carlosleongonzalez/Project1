package service;

import java.util.List;

import exception.ApplicationException;
import pojo.LaptopPojo;
import pojo.ReimbursementPojo;

public interface ReimbursementService {
	
	ReimbursementPojo addReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException;

	ReimbursementPojo updateReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException;

	boolean deleteReimbursement(int reimbursementId) throws ApplicationException;

	List<ReimbursementPojo> getAllReimbursements() throws ApplicationException;

	ReimbursementPojo getAReimbursement(int reimbursementId) throws ApplicationException;

	void exitApplication();

}
