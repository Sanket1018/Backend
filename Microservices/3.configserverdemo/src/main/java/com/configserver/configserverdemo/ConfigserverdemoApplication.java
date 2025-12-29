package com.configserver.configserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableConfigServer
public class ConfigserverdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverdemoApplication.class, args);
	}

}
