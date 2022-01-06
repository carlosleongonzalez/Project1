package service;

import java.util.List;

import exception.ApplicationException;
import pojo.LaptopPojo;

public interface LaptopService {
	LaptopPojo addLaptop(LaptopPojo laptopPojo) throws ApplicationException;

	LaptopPojo updateLaptop(LaptopPojo laptopPojo) throws ApplicationException;

	boolean deleteLaptop(int laptopId) throws ApplicationException;

	List<LaptopPojo> getAllLaptops() throws ApplicationException;

	LaptopPojo getALaptop(int laptopId) throws ApplicationException;

	void exitApplication();

}
