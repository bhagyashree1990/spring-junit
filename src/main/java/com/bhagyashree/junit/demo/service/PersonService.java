package com.bhagyashree.junit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagyashree.junit.demo.model.Person;
import com.bhagyashree.junit.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll(){
		System.out.println("PersonService::findAll");
		return personRepository.findAll();
	}
	
	public Person getYoungest() {
		System.out.println("PersonService::getYoungest");
		List<Person> persons = personRepository.findAll();
		System.out.println("Sorting list");
		persons.sort(Person.byDateOfBirth.reversed());
		return persons.get(0);
	}
}
