package com.revature.entity;

import java.util.Date;

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
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "createdOn")
	private Date createdOn;
	
	@Column(name = "lastLogin")
	private Date lastLogin;
	
	@Column(name = "resetToken")
	private String resetToken;
	
//	columnDefinition forces the role to be either MANAGER, CUSTOMER, or VENDOR
	@Column(name="role", columnDefinition = "VARCHAR2(50) CHECK (role IN ('MANAGER', 'CUSTOMER', 'VENDOR'))")
	private String role;
	
	public Client() {}

	public Client(long id, String firstName, String lastName, String email, String password, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public Client(long id) {
		this.id = id;
	}
	
	public Client(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public Client(String email) {
		this.email = email;
	}
	
	public Client(int id) {
		this.id = id;
	}
	
	
	public Client(String email, String password, String firstName, String lastName,
			Date createdOn, Date lastLogin, String resetToken, String role) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdOn = createdOn;
		this.lastLogin = lastLogin;
		this.resetToken = resetToken;
		this.role=role;
		
	}

	public Client(long id, String email, String password, String firstName, String lastName,
			Date createdOn, Date lastLogin, String resetToken, String role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdOn = createdOn;
		this.lastLogin = lastLogin;
		this.resetToken = resetToken;
		this.role=role;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", createdOn=" + createdOn + ", lastLogin=" + lastLogin + ", resetToken="
				+ resetToken + ", role=" + role + "]";
	}

	

}