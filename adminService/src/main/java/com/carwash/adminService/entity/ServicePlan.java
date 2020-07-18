package com.carwash.adminService.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "serviceplan")
public class ServicePlan {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	private long serviceplan_id;
	private String 	serviceplan_name;
	private Double price;

	public ServicePlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicePlan(long serviceplan_id, String serviceplan_name, Double price) {
		super();
		this.serviceplan_id = serviceplan_id;
		this.serviceplan_name = serviceplan_name;
		this.price = price;
	}

	public long getServiceplan_id() {
		return serviceplan_id;
	}

	public void setServiceplan_id(long serviceplan_id) {
		this.serviceplan_id = serviceplan_id;
	}

	public String getServiceplan_name() {
		return serviceplan_name;
	}

	public void setServiceplan_name(String serviceplan_name) {
		this.serviceplan_name = serviceplan_name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ServicePlan [serviceplan_id=" + serviceplan_id + ", serviceplan_name=" + serviceplan_name + ", price="
				+ price + "]";
	}

}