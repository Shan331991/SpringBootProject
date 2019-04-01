package com.shan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "user")
@Entity
public class User {

	@Id
	private long id;
	private String username;
	private String password;
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)

	private Employee employee;

	public User() {
		super();
	}

	public User(long id, String username, String password, String email, Employee employee) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
