package com.security_demo.spring_security_demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security_demo.spring_security_demo.model.Alien;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Aliencontroller {
	
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
	
	@GetMapping("/course-info")
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

}
