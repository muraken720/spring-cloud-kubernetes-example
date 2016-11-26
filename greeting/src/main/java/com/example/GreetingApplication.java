package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
public class GreetingApplication {

	@Autowired
	private GreetingService service;

	@RequestMapping(path = "/")
	String greeting() {
		return "Greeting: " + service.getResponse();
	}

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}
}
