package com.test.po;

public class Subject {
	private int subject_id;
	private String subject_title;
	private int subject_class;
	
	public int getSubject_id(){
		return subject_id;
	}
	public String getSubject_title(){
		return subject_title;
	}
	public int getSubject_class(){
		return subject_class;
	}
	
	public void setSubject_id(int subject_id){
		this.subject_id=subject_id;
	}
	public void setSubject_title(String subject_title){
		this.subject_title=subject_title;
	}
	public void setSubject_class(int subject_class){
		this.subject_class=subject_class;
	}
	
}
