package com.simplejavatest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "USER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

	@Id
	private int id;
	private String name;
	private String country;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserProgress userprogress;

	public User() {
		super();
	}

	public User(int id, String name, String country, UserProgress userprogress) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.userprogress = userprogress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserProgress getUserprogress() {
		return userprogress;
	}

	public void setUserprogress(UserProgress userprogress) {
		this.userprogress = userprogress;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", country=" + country + ", userprogress=" + userprogress + "]";
	}

}
