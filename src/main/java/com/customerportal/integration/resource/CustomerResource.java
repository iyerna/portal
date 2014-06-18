package com.customerportal.integration.resource;

import java.io.Serializable;


public class CustomerResource implements Serializable {
	
	private static final long serialVersionUID = -7788619177798333712L;
	
	private long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	
	public long getId() { return id; }
	
	public void setId(long id) { this.id = id; }
	
	public String getUserName() { return userName; }
	
	public void setUserName(String userName) { this.userName = userName; }
	
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

	@Override
	public String toString() {
		return "CustomerResource [ id="+ id
				+ ", username=" + userName
				+ ", firstname=" + firstName
				+ ", lastname=" + lastName
				+ ", email=" + email
				+ "]";
	}
}
