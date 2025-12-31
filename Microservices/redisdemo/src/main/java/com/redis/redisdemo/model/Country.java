package com.redis.redisdemo.model;

import java.io.Serializable;

public class Country implements Serializable {
	private Integer no;
	private String name;
	private String countryCode;
	public Integer getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "Country [no=" + no + ", name=" + name + ", countryCode=" + countryCode + "]";
	}
	
}
