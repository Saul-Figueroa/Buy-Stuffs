package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name", length=50)
	private String name;
	
	@Column(name="email", length=50)
	private String email;
	
	@Column(name="password", length=50)
	private String password;
	
//	columnDefinition forces the role to be either MANAGER or CUSTOMER
	@Column(name="role", columnDefinition = "VARCHAR2(50) CHECK (role IN ('MANAGER', 'CUSTOMER', 'VENDOR'))")
	private String role;
	
	public Client() {}

	public Client(long id, String name, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public Client(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}

}