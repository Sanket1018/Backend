package com.user.userdemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Value("${msg}")
	private String msg;
	
	// When ever there is dynamic configuration we are going to use config server
	@GetMapping("/get-timing")
	public String getCourseTimng()
	{
		return msg;
	}
	
	

}
