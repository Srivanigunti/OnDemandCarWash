package com.carwash.adminService.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
    private Long user_id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long user_id, String email, String password, String name, String phone, String address) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", phone=" + phone + ", address=" + address + "]";
	}

}