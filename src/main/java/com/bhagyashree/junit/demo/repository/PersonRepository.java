package com.bhagyashree.junit.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.bhagyashree.junit.demo.model.Person;

@Repository
public class PersonRepository {

	public List<Person> findAll() {
		System.out.println("PersonRepository::findAll");
		List<Person> persons = Stream.of(
				new Person("Bhagyashree", "Chavan", LocalDate.of(1990, 4, 1)),
				new Person("Vipul", "Pai", LocalDate.of(1997, 3, 8)),
				new Person("Sanika", "Sawant", LocalDate.of(1996, 8, 16))
						).collect(Collectors.toList());
		
		return persons;
	}
}
