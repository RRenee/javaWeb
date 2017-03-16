package com.test.po;

public class Answer {
	private int user_id;
	private String answer;
	private int score;
	
	public void setUser_id(int user_id){
		this.user_id=user_id;
	}
	public void setAnswer(String answer){
		this.answer=answer;
	}
	public void setScore(int score){
		this.score=score;
	}
	
	public int getUser_id(){
		return user_id;
	}
	public String getAnswer(){
		return answer;
	}
	public int getScore(){
		return score;
	}
}
