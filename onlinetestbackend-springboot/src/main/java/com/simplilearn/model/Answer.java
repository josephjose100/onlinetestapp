package com.simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer {
    
	@Id
	private int id;
	private String ans;
	
	public Answer() {
		
	}

	public Answer(int id, String ans) {
		super();
		this.id = id;
		this.ans = ans;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
	
}