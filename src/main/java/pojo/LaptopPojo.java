package pojo;

import java.util.Objects;

public class LaptopPojo {

	private int id;
	private String laptopModel;
	private String laptopBrand;
	private int laptopCost;
	private boolean laptopRemoved;
	private String laptopImage;
	public LaptopPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LaptopPojo(int id, String laptopModel, String laptopBrand, int laptopCost, boolean laptopRemoved,
			String laptopImage) {
		super();
		this.id = id;
		this.laptopModel = laptopModel;
		this.laptopBrand = laptopBrand;
		this.laptopCost = laptopCost;
		this.laptopRemoved = laptopRemoved;
		this.laptopImage = laptopImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLaptopModel() {
		return laptopModel;
	}
	public void setLaptopModel(String laptopModel) {
		this.laptopModel = laptopModel;
	}
	public String getLaptopBrand() {
		return laptopBrand;
	}
	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}
	public int getLaptopCost() {
		return laptopCost;
	}
	public void setLaptopCost(int laptopCost) {
		this.laptopCost = laptopCost;
	}
	public boolean isLaptopRemoved() {
		return laptopRemoved;
	}
	public void setLaptopRemoved(boolean laptopRemoved) {
		this.laptopRemoved = laptopRemoved;
	}
	public String getLaptopImage() {
		return laptopImage;
	}
	public void setLaptopImage(String laptopImage) {
		this.laptopImage = laptopImage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LaptopPojo other = (LaptopPojo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LaptopPojo [id=" + id + ", laptopModel=" + laptopModel + ", laptopBrand=" + laptopBrand
				+ ", laptopCost=" + laptopCost + ", laptopRemoved=" + laptopRemoved + ", laptopImage=" + laptopImage
				+ "]";
	}
	








}
	