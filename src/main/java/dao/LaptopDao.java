package dao;

import java.util.List;

import pojo.LaptopPojo;
import exception.ApplicationException;

public interface LaptopDao {
	LaptopPojo addLaptop(LaptopPojo laptopPojo) throws ApplicationException;

	LaptopPojo updateLaptop(LaptopPojo laptopPojo) throws ApplicationException;

	boolean deleteLaptop(int laptopId) throws ApplicationException;

	List<LaptopPojo> getAllLaptops() throws ApplicationException;

	LaptopPojo getALaptop(int laptopId) throws ApplicationException;

	void exitApplication();

}
