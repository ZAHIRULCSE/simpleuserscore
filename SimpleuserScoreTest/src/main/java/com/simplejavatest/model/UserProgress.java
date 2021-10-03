package com.simplejavatest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="USERPROGRESS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class UserProgress {
	
	@Id
	private int id;
	
	private int level;
	
	private float score;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public UserProgress() 
	{
		super();
	}

	public UserProgress(int id, int level, float score, User user) {
		super();
		this.id = id;
		this.level = level;
		this.score = score;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserProgress [id=" + id + ", level=" + level + ", score=" + score + ", user=" + user + "]";
	}
	
	

}
