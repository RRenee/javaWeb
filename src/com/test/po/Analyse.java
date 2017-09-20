package com.test.po;

public class Analyse {
	private String subject;
	private String analysis;
	private int score;
	public void setSubject(String subject){
		this.subject=subject;
	}
	public void setAnalysis(String analysis){
		this.analysis=analysis;
	}
	public String getSubject(){
		return subject;
	}
	public String getAnalysis(){
		return analysis;
	}
	public void setScore(int score){
		this.score=score;
	}
	public int getScore(){
		return score;
	}
}
