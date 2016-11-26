package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class BazServiceApplication {

	@Autowired
	private AppConfig config;

	@RequestMapping(path = "/")
	String hello() {
		return config.getMessage() + " @ " + config.getFrom();
	}

	public static void main(String[] args) {
		SpringApplication.run(BazServiceApplication.class, args);
	}
}
