package com.test.po;
import java.util.List;
import java.util.ArrayList;
public class SubjectInf {
	public String subject_class;
	public List<Subject> subject=new ArrayList<Subject>(10);
	//public List<Subject> subject;
	public void setSubject_class(String subject_class){
		this.subject_class=subject_class;
	}
	public void addSubject(Subject subject){
		this.subject.add(subject);
	}
	
	public String getSubject_class(){
		return subject_class;
	}
	public Subject getSubject(int number){
		return subject.get(number);
	}
}
