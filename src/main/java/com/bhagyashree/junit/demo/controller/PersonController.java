package com.bhagyashree.junit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhagyashree.junit.demo.model.Person;
import com.bhagyashree.junit.demo.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@GetMapping("/youngest")
	public Person getYoungest() {
		System.out.println("PersonController::getYoungest");
		return personService.getYoungest();
	}
}
