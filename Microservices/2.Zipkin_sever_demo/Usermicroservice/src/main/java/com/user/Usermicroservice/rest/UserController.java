package com.user.Usermicroservice.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	

	@Autowired
	private Environment env;

	@GetMapping("/course-info")
	public ResponseEntity<String> getCourseInfo()
	{
		String portNo = env.getProperty("server.port");
		//String info = service.getCourseInfo();
		String info = "Amazon launched AWS and Devops course abcdefg " +portNo;
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}

}



