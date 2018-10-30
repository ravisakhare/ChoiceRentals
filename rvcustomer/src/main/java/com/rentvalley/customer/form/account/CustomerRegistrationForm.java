package com.rentvalley.customer.form.account;

public class CustomerRegistrationForm {
	protected String firstName;
	protected String lastName;
	protected String emailAddress;
	protected String mobile;
	protected String password;
	protected String retypePassword;
	protected String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	@Override
	public String toString() {
		return "RenteeRegistrationForm [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", mobile=" + mobile + ", password=" + password + ", retypePassword=" + retypePassword
				+ ", role=" + role + "]";
	}
}
