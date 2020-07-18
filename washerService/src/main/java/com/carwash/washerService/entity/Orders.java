package com.carwash.washerService.entity;
import java.util.Date;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "WashOrderDetails")
public class Orders {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	public Integer custID;
	public Integer carID;
	public Integer washTypeID;
	public Date orderDate;
	public String washLocation;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(Integer custID, Integer carID, Integer washTypeID, Date orderDate, String washLocation) {
		super();
		this.custID = custID;
		this.carID = carID;
		this.washTypeID = washTypeID;
		this.orderDate = orderDate;
		this.washLocation = washLocation;
	}
	public Integer getCustID() {
		return custID;
	}
	public void setCustID(Integer custID) {
		this.custID = custID;
	}
	public Integer getCarID() {
		return carID;
	}
	public void setCarID(Integer carID) {
		this.carID = carID;
	}
	public Integer getWashTypeID() {
		return washTypeID;
	}
	public void setWashTypeID(Integer washTypeID) {
		this.washTypeID = washTypeID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getWashLocation() {
		return washLocation;
	}
	public void setWashLocation(String washLocation) {
		this.washLocation = washLocation;
	}
	
	@Override
	public String toString() {
		return "Orders [custID=" + custID + ", carID=" + carID + ", washTypeID=" + washTypeID + ", orderDate="
				+ orderDate + ", washLocation=" + washLocation + "]";
	}


}

