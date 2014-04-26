package com.example.ormlitedemo;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Note {
	@DatabaseField(generatedId=true)
	int id;
	@DatabaseField
	String subject;
	@DatabaseField
	String text;
	@DatabaseField
	Date date;
	
	public Note(){
		
	}

	public Note(int id, String subject, String text, Date date) {
		super();
		this.id = id;
		this.subject = subject;
		this.text = text;
		this.date = new Date(System.currentTimeMillis());
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", subject=" + subject + ", text=" + text
				+ ", date=" + date + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	

}
