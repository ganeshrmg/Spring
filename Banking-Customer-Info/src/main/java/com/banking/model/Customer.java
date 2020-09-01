package com.banking.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.validation.constraints.Email;

public class Customer {
	
	@NotNull(message="Name must be Required")
	@Size(min=3,message="Minimum 3 characters Required")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotNull(message="Username must be Required")
	@Size(min=3,message="Minimum 3 characters Required")
	private String username;	
	
	@NotNull(message="Address must be Required")
	@Size(min=3,message="Minimum 3 characters Required")
	private String address;
	
	@NotNull(message="Email must be Required")
	@Email(message = "Email should be valid")	
	private String email;
	
	@NotNull(message="State must be Required")
	@Size(min=3,message="Minimum 3 characters Required")
	private String state;
	
	@NotNull(message="Country must be Required")
	@Size(min=3,message="Minimum 3 characters Required")
	private String country;
	
	@NotNull(message="PAN must be Required")
	@Size(min=3,message="Minimum 3 characters Required")
	private String pan;
	
	@NotNull(message="contact must be Required")
	@Size(min=10,message="Minimum digits Required")
	private String contact;
	
	@NotNull(message="Dob must be Required")
	private Date dob;
	
	@NotNull(message="Account must be Required")
	@Size(min=3,message="Minimum 3 characters Required")
	private String account;
	
	@NotNull(message="Password must be Required")
	@Size(min=3,message="Minimum 3 characters Required")
	private String password;
	
	
	
	
}
