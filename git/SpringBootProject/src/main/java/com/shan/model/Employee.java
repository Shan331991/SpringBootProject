package com.shan.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="employee")
@Entity
public class Employee {

	@Id
	private long Id;
	private String fname;
	private String email;
	private String designation;
	private Date joining_date;
	
	public long getId() {
		return Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	public String getfname() {
		return fname;
	}
	public void setEmpName(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmailId(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}
	
	

}
