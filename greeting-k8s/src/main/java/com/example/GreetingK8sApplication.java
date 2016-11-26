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
public class GreetingK8sApplication {

	@Autowired
	private GreetingK8sService service;

	@RequestMapping(path = "/")
	String greeting() {
		return "Greeting: " + service.callFoo() + ", " + service.callBar();
	}

	public static void main(String[] args) {
		SpringApplication.run(GreetingK8sApplication.class, args);
	}
}
