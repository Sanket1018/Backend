package com.user.Usermicroservice.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	

	@GetMapping("/course-info")
	public ResponseEntity<String> getCourseInfo()
	{
		String info = "Amazon launched AWS and Devops course abcdefg";
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}

}
