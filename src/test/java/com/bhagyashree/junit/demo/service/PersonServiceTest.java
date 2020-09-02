package com.bhagyashree.junit.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bhagyashree.junit.demo.model.Person;
import com.bhagyashree.junit.demo.repository.PersonRepository;
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	/***
	 * Comparing response as object
	 */
	@Test
	void testGetYoungest() {
		Person personExpected = new Person("Vipul", "Pai", LocalDate.of(1997, 3, 8));
		Person personAshwini = new Person("Ashwini","Mhatre",LocalDate.of(1975, 9, 25));
		List<Person> persons = Arrays.asList(personAshwini,personExpected);
		
		when(personRepository.findAll()).thenReturn(persons);
		Person personActual = personService.getYoungest();
		
		assertThat(personActual).isEqualToComparingFieldByField(personExpected);
	}

}
