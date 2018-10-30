package com.rentvalley.dto.account;

import java.util.Date;

public class ContactInfoDto {
	private int contactInfoNo;
	private String contactNo;
	private String emailAddress;
	private String createdBy;
	private Date createdDate;
	private String lastModifiedBy;
	private Date lastModifiedDate;

	public ContactInfoDto(String contactNo) {
		this.contactNo = contactNo;
	}

	public ContactInfoDto(String contactNo, String emailAddress) {
		this.contactNo = contactNo;
		this.emailAddress = emailAddress;
	}

	public int getContactInfoNo() {
		return contactInfoNo;
	}

	public void setContactInfoNo(int contactInfoNo) {
		this.contactInfoNo = contactInfoNo;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
