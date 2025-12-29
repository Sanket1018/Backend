package com.user.Usermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsermicroserviceApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(UsermicroserviceApplication1.class, args);
	}

}
