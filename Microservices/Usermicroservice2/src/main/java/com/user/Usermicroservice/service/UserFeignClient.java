package com.user.Usermicroservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="USERMICROSERVICE")
public interface UserFeignClient {
	

    @GetMapping("/course-info")
	public ResponseEntity<String> getCourseInfo();

}
