package com.rentvalley.bo.account;

import java.io.Serializable;
import java.util.Arrays;

public class MailMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected String from;
	protected String to;
	protected String[] cc;
	protected String[] bcc;
	protected String subject;
	protected String body;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MailMessage [from=" + from + ", to=" + to + ", cc=" + Arrays.toString(cc) + ", bcc="
				+ Arrays.toString(bcc) + ", subject=" + subject + ", body=" + body + "]";
	}

}
