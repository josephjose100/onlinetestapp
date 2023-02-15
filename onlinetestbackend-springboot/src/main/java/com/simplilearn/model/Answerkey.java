package com.simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answerkey {

  @Id
  private int id;
  private String aKey;
  public Answerkey() {
	
  }
  public Answerkey(int id, String aKey) {
	super();
	this.id = id;
	this.aKey = aKey;
  }
  public int getId() {
	return id;
  }
  public void setId(int id) {
	this.id = id;
  }
  public String getaKey() {
	return aKey;
  } 
  public void setaKey(String aKey) {
	this.aKey = aKey;
  }
  
}
