

package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author ${Satyam kumar}
 *
 *
 *
 *@Entity
 *this annotation marks this class as an entity. @Table annotation specifies the table name where data of this entity is to be persisted. 
 * 
 * @Id annotation specifies the primary key of an entity 
 * 
 * 
 * @ override
 * The @Override annotation informs the compiler that the element is meant to override an element declared in a superclass.
 *
 */




@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String mobile;
	@Column
	private String address;
	@Column
	private String email;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", mobile=" + mobile + ", address="
				+ address + ", email=" + email + "]";
	}

	public User(int userId, String fname, String lname, String mobile, String address, String email) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
	}

	
}
