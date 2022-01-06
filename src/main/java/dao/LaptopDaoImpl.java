package dao;

import java.util.ArrayList;
import java.util.List;

import pojo.LaptopPojo;

public class LaptopDaoImpl implements LaptopDao {

	List<LaptopPojo> allLaptopsStore;

	public LaptopDaoImpl() {
		this.allLaptopsStore = new ArrayList<LaptopPojo>();
	}

	@Override
	public LaptopPojo addLaptop(LaptopPojo laptopPojo) {
		laptopPojo.setId(allLaptopsStore.size() + 1);
		allLaptopsStore.add(laptopPojo);
		return laptopPojo;
	}

	@Override
	public LaptopPojo updateLaptop(LaptopPojo laptopPojo) {
		System.out.println(laptopPojo.getId());
		for (int i = 0; i < allLaptopsStore.size(); i++) {
			System.out.println(allLaptopsStore.get(i).getId());
			if (allLaptopsStore.get(i).getId() == laptopPojo.getId()) {
				System.out.println("Match found!");
				allLaptopsStore.set(i, laptopPojo);
				break;
			}
		}
		return laptopPojo;

	}

	// later
	@Override
	public boolean deleteLaptop(int laptopId) {
		int currentSize = allLaptopsStore.size();
		allLaptopsStore.removeIf(laptopPojo -> laptopPojo.getId() == laptopId);
		int nowSize = allLaptopsStore.size();
		if (currentSize == nowSize) {
			return false;
		} else {
			return true;
		}

	}

	// later
	@Override
	public List<LaptopPojo> getAllLaptops() {

		return allLaptopsStore;
	}

	public LaptopPojo getALaptop(int laptopId) {
		for (LaptopPojo laptopPojo : allLaptopsStore) {
			if (laptopPojo.getId() == laptopId) {
				return laptopPojo;
			}
		}
		return null;
	}

	@Override
	public void exitApplication() {
		// TODO Auto-generated method stub

	}

}
