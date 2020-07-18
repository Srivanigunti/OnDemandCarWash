package com.carwash.adminService.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "promocode")
public class PromoCode {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	private long promocode;
	private Integer discount;

	public PromoCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromoCode(long promocode, Integer discount) {
		super();
		this.promocode = promocode;
		this.discount = discount;
	}

	public long getPromocode() {
		return promocode;
	}

	public void setPromocode(long promocode) {
		this.promocode = promocode;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "PromoCode [promocode=" + promocode + ", discount=" + discount + "]";
	}

}