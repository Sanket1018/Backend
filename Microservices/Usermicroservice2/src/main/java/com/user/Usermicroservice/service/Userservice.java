package com.user.Usermicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Userservice {
	
	@Autowired
	private UserFeignClient feignClient;
	
	public String getCourseInfo()
	{
		// if you want to take a data from another REST API
		// we are going to use REST template
		// REST Templates are not good because we have to mention the localhost here
		// So in case of multiple or lakhs of request a single instance of server cannot handle the larger number of request
		// RestTemplate rest = new RestTemplate();
		// ResponseEntity<String> response = rest.getForEntity("http://localhost:8481/course/course-info", String.class);
		// so option is to use the feign client
		// Using feign client it will update the port accordingly
		
		ResponseEntity<String> response = feignClient.getCourseInfo();
		return response.getBody()+" Comming from another resource"; // Coming from the another the REST APIS
	}
	

}
