package com.redis.redisdemo.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.redis.redisdemo.model.Country;

@Service
public class CountryService {
	private HashOperations<String,Object,Object> opsForHash = null;
	
	public CountryService(RedisTemplate<String, Country> redis)
	{
		opsForHash = redis.opsForHash();
	}
	
	public String addCountry(@RequestBody Country country)
	{
		opsForHash.put("COUNTRIES", country.getNo(),country);
		return "Country data added into the redis server"; 
	}

}
