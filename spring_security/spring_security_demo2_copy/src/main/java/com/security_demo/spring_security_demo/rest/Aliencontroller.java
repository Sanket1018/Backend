package com.security_demo.spring_security_demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security_demo.spring_security_demo.entity.Users;
import com.security_demo.spring_security_demo.model.Alien;
import com.security_demo.spring_security_demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Aliencontroller {
	
	@Autowired
	private UserService service;
	
	// Manually we are creating some data
	List<Alien> list = new ArrayList<>(List.of(new Alien(1,"Sanket","Sangli"),
			new Alien(2,"Abhishek","Mumbai")));
	
	@GetMapping("/get-aliens")
	public List<Alien>getAliens()
	{
		return list;
	}
	
	@PostMapping("/add-aliens")
	public void addAlien(@RequestBody Alien alien)
	{
		list.add(alien);
		System.out.println(list);
	}
	
	@GetMapping("/info")
	public String getCourseInfo(HttpServletRequest request)
	{
		return "This is the course from the "+request.getSession().getId();
	}
	
	public String getMoreCourseInfo(HttpServletRequest request)
	{
		return "This is about the all courses "+request.getSession().getId();
	}
	
	@GetMapping("/csrf")
	public CsrfToken getCsrftoken(HttpServletRequest request)
	{
		return (CsrfToken)request.getAttribute("_csrf");
	}
	
	@PostMapping("/register")
	public Users register(Users users)
	{
		return service.register(users);
	}
	

}
