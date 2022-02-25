package com.dukaan.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DukaanModel {
	
	@Id
	private String user_id;
	private String password;
	private String fname;
	private String lname;
	private String email;
	private String dob;
	private String address;
	private int ph;
	//private boolean role;
	private String gender;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
//	@Override
//	public String toString() {
//		return "DukaanModel [user_id=" + user_id + ", password=" + password + ", fname=" + fname + ", lname=" + lname
//				+ ", email=" + email + ", dob=" + dob + ", address=" + address + ", ph=" + ph + ", role=" + role + "]";
//	}
//	public boolean isRole() {
//		return role;
//	}
//	public void setRole(boolean role) {
//		this.role = role;
//	}
	public DukaanModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}
	 
	
}
