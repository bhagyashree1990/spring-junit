package com.bhagyashree.junit.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	public String greetHello(String name) {
		return "Hello "+name;
	}
}
