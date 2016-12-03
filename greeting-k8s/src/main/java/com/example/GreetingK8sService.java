package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class GreetingK8sService {

	@Autowired
	private RestTemplate restTemplate;

//	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@HystrixCommand(fallbackMethod = "fallbackCallFoo", commandKey = "GreetingK8s.callFoo")
	public String callFoo() {
		return restTemplate.getForObject("http://foo-service", String.class);
	}
	
	public String fallbackCallFoo() {
		return "FooService not available now.";
	}

	@HystrixCommand(fallbackMethod = "fallbackCallBar", commandKey = "GreetingK8s.callBar")
	public String callBar() {
		return restTemplate.getForObject("http://bar-service", String.class);
	}
	
	public String fallbackCallBar() {
		return "BarService not available now.";
	}
}
