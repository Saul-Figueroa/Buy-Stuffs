package com.revature.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="USERS" )
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private long id;
	
	@Column(name = "email", nullable = false, unique = true )
	@Email(message = "Please enter a valid e-mail")
	@NotEmpty(message = "Please enter an e-mail")
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "first_name")
	@NotEmpty(message = "Please enter your first name ")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "Please enter your last name")
	private String lastName;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "created-on")
	private Date createdOn;
	
	@Column(name = "last_login")
	private Date lastLogin;
	
	@Column(name = "reset_token")
	private String resetToken;
	
	
	public User() { }
	
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(String email, String password, String firstName, String lastName, boolean enabled,
			Date createdOn, Date lastLogin, String resetToken) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enabled = enabled;
		this.createdOn = createdOn;
		this.lastLogin = lastLogin;
		this.resetToken = resetToken;
	}

	public User(long id, String email, String password, String firstName, String lastName, boolean enabled,
			Date createdOn, Date lastLogin, String resetToken) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enabled = enabled;
		this.createdOn = createdOn;
		this.lastLogin = lastLogin;
		this.resetToken = resetToken;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", enabled=" + enabled + ", createdOn=" + createdOn + ", lastLogin="
				+ lastLogin + ", resetToken=" + resetToken + "]";
	}
	

}
