package com.carwash.washerService.entity;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "washerDetails")
public class Profile {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	public long id;
	private String firstName;
	private String lastName;
	public String password;
	public String emailId;
	public String phNum;
	public String address;
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(long id, String firstName, String lastName, String password, String emailId, String phNum,
			String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.emailId = emailId;
		this.phNum = phNum;
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Profile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", emailId=" + emailId + ", phNum=" + phNum + ", address=" + address + "]";
	}

}

