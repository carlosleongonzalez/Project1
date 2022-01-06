package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.LaptopDao;
import dao.LaptopDaoImpl;
import dao.LaptopJdbcDaoImpl;
import dao.DBUtil;
import exception.ApplicationException;


import pojo.LaptopPojo;

public class LaptopServiceImpl implements LaptopService {

	private static final Logger logger = LogManager.getLogger(LaptopServiceImpl.class);

	LaptopDao laptopDao;

	public LaptopServiceImpl() {

//		this.laptopDao = new LaptopDaoImpl();
		this.laptopDao = new LaptopJdbcDaoImpl();
	}

	@Override
	public LaptopPojo addLaptop(LaptopPojo laptopPojo) throws ApplicationException {

		logger.info("Entered addLaptop() in service.");
		LaptopPojo returnLaptopPojo = this.laptopDao.addLaptop(laptopPojo);
		logger.info("Exited addLaptop() in service.");
		return returnLaptopPojo;

//		return this.laptopDao.addLaptop(laptopPojo);
	}

	@Override
	public LaptopPojo updateLaptop(LaptopPojo laptopPojo) throws ApplicationException {

		logger.info("Entered updateLaptop() in service.");
		LaptopPojo returnLaptopPojo = this.laptopDao.updateLaptop(laptopPojo);
		logger.info("Exited updateLaptop() in service.");
		return returnLaptopPojo;

//		return this.laptopDao.updateLaptop(laptopPojo);

	}

	@Override
	public boolean deleteLaptop(int laptopId) throws ApplicationException {
		logger.info("Entered deleteLaptop() in service.");
		boolean returnFlag = this.laptopDao.deleteLaptop(laptopId);
		logger.info("Exited deleteLaptop() in service.");
		return returnFlag;

//		return this.laptopDao.deleteLaptop(laptopId);

	}

	@Override
	public List<LaptopPojo> getAllLaptops() throws ApplicationException {

		logger.info("Entered getAllLaptops() in service.");
		List<LaptopPojo> allLaptops = this.laptopDao.getAllLaptops();
		logger.info("Exited getAllLaptops() in service.");
		return allLaptops;

//		return this.laptopDao.getAllLaptops();
	}

	@Override
	public LaptopPojo getALaptop(int laptopId) throws ApplicationException {

		logger.info("Entered getALaptop() in service.");
		LaptopPojo returnLaptopPojo = this.laptopDao.getALaptop(laptopId);
		logger.info("Exited getALaptop() in service.");
		return returnLaptopPojo;
//		return this.laptopDao.getALaptop(laptopId);
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		laptopDao.exitApplication();
		logger.info("Exited exitApplication() in service.");

	}
}