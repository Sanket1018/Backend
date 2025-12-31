package com.user.Usermicroservice.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.Usermicroservice.service.Userservice;

@RestController
public class UserController {
	
	@Autowired
	private Userservice service;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/course/course-info")
	public ResponseEntity<String> getCourseInfo()
	{
		String portNo = env.getProperty("server.port");
		String info = service.getCourseInfo();
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}

}
