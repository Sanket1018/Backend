package com.example.OAuth.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/info")
	public String getCourseInfo()
	{
		return "Telusko launched a new devops course";
	}
	

}
