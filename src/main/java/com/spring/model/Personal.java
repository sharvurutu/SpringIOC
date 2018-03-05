package com.spring.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Personal {
	@Autowired
	private UserInfo user;
	private String mobile;
	
	public Personal() {
		
	}
	public Personal(String mobile) {
		this.mobile = mobile;
	}
	
	public UserInfo getUser() {
		return user;
	}
	

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
