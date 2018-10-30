package com.rentvalley.bo.account;

import java.util.Date;

public class UserAccountBo {
	private int systemUserNo;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private ContactInfoBo contactInfoBo;
	private RoleBo roleBo;
	private String registeredDate;
	private Date activatedDate;
	private String activationCode;
	private String status;
	private String createdBy;
	private Date createdDate;
	private String lastModifiedBy;
	private Date lastModifiedDate;

	
	public RoleBo getRoleBo() {
		return roleBo;
	}

	public void setRoleBo(RoleBo roleBo) {
		this.roleBo = roleBo;
	}

	public ContactInfoBo getContactInfoBo() {
		return contactInfoBo;
	}

	public void setContactInfoBo(ContactInfoBo contactInfoBo) {
		this.contactInfoBo = contactInfoBo;
	}

	public int getSystemUserNo() {
		return systemUserNo;
	}

	public void setSystemUserNo(int systemUserNo) {
		this.systemUserNo = systemUserNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Date getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
