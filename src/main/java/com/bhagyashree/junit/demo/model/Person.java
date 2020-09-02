package com.bhagyashree.junit.demo.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Person {
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	
	public static Comparator<Person> byDateOfBirth = Comparator.comparing(Person::getDateOfBirth);
	
	public Person(String firstName, String lastName, LocalDate dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
