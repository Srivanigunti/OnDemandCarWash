package com.carwash.adminService.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addon")
public class AddOn {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	private long addonid;
	private String name;
	private Double price;

	public AddOn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddOn(long addonid, String name, Double price) {
		super();
		this.addonid = addonid;
		this.name = name;
		this.price = price;
	}

	public long getAddonid() {
		return addonid;
	}

	public void setAddonid(long addonid) {
		this.addonid = addonid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "AddOn [addonid=" + addonid + ", name=" + name + ", price=" + price + "]";
	}

}
