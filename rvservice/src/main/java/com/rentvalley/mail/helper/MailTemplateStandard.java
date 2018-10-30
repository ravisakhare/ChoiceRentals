package com.rentvalley.mail.helper;

public class MailTemplateStandard {
	protected int userId;
	protected String userName;
	protected String activationCode;

	public MailTemplateStandard(int userId, String userName, String activationCode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.activationCode = activationCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	@Override
	public String toString() {
		return "MailTemplateStandard [userId=" + userId + ", userName=" + userName + ", activationCode="
				+ activationCode + "]";
	}
	
}
