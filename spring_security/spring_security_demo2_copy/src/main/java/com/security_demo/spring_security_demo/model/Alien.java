package com.security_demo.spring_security_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
	@Id
	private Integer id;
	private String name;
	private String city;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Alien(Integer id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Alien() {
		super();
		// TODO Auto-generated constructor stub
	}

}
