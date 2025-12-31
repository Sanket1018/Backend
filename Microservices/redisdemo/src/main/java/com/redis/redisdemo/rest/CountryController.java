package com.redis.redisdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.redisdemo.model.Country;
import com.redis.redisdemo.service.CountryService;

import lombok.AllArgsConstructor;

@RestController
public class CountryController {
	
	@Autowired
	private CountryService service;
	
	@PostMapping("/addCountry")
	public String addCountry(@RequestBody Country country)
	{
		return service.addCountry(country);
	}
	

}
