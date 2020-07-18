package com.carwash.adminService.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cardetails")
public class CarDetails {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	private long carId;
	private String carname;
	private String cartype;
	private String colour;
	private String reg_number;
	private String imageUrl;

	public CarDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarDetails(long carId, String carname, String cartype, String colour, String reg_number, String imageUrl) {
		super();
		this.carId = carId;
		this.carname = carname;
		this.cartype = cartype;
		this.colour = colour;
		this.reg_number = reg_number;
		this.imageUrl = imageUrl;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getReg_number() {
		return reg_number;
	}

	public void setReg_number(String reg_number) {
		this.reg_number = reg_number;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "CarDetails [carId=" + carId + ", carname=" + carname + ", cartype=" + cartype + ", colour=" + colour
				+ ", reg_number=" + reg_number + ", imageUrl=" + imageUrl + "]";
	}
	
}
