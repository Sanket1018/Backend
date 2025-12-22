package com.user.Usermicroservice.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.Usermicroservice.service.Userservice;

@RestController
public class UserController {
	
	@Autowired
	private Userservice service;
	
	@GetMapping("course-info")
	public ResponseEntity<String> getCourseInfo()
	{
		String info = service.getCourseInfo();
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}

}
