package com.example;

import java.util.UUID;

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
public class BarApplication {

	private static final UUID id = UUID.randomUUID();
	private static int count = 0;

	@Autowired
	private BarService service;

	@RequestMapping(path = "/")
	String say() {
		return "Bar @" + id + ", count = " + count++ + ", " + service.getResponse();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BarApplication.class, args);
	}
}
