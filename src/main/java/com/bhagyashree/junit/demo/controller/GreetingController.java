package com.bhagyashree.junit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhagyashree.junit.demo.service.GreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Autowired
	private GreetingService greetingService;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name",defaultValue = "World")String name) {
		return greetingService.greetHello(name);
	}
	
	@GetMapping
	public String greet() {
		return "Good Day!";
	}
}
