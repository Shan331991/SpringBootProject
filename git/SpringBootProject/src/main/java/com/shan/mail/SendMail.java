package com.shan.mail;

public class SendMail {

	private String from;
	private String to;
	private String subject;
	private String message;
	
	public SendMail() {
		this.to=new String();
		
	}

	public SendMail(String from, String toList, String subject, String message) {
		this();
		this.from = from;
		this.subject = subject;
		this.message = message;
		this.to=toList;
	}
	
	public SendMail(String from, String toList, String ccList, String subject, String message) {
		this();
		this.from = from;
		this.subject = subject;
		this.message = message;
		this.to=toList;
	}
	private String[] splitByComma(String toMultiple) {
		String[] toSplit=toMultiple.split(",");
		return toSplit;
	}

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
