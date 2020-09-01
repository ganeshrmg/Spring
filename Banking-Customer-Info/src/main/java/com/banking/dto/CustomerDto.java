package com.banking.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class CustomerDto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;	
	private String username;	
	private String address;
	private String email;
	private String state;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getDuestatus() {
		return duestatus;
	}
	public void setDuestatus(String duestatus) {
		this.duestatus = duestatus;
	}
	public String getDueapproval() {
		return dueapproval;
	}
	public void setDueapproval(String dueapproval) {
		this.dueapproval = dueapproval;
	}
	private String country;
	private String pan;
	private String contact;
	private Date dob;
	private String account;
	private String password;
    private Integer score;	
    private String duestatus;
	private String dueapproval;
}
