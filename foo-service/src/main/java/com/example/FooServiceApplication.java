package com.example;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class FooServiceApplication {

	private static final UUID id = UUID.randomUUID();
	private static int count = 0;

	@RequestMapping(path = "/")
	String say() {
		return "Foo @" + id + ", count = " + count++;
	}

	public static void main(String[] args) {
		SpringApplication.run(FooServiceApplication.class, args);
	}
}
