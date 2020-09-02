package com.bhagyashree.junit.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.bhagyashree.junit.demo.model.Person;
import com.bhagyashree.junit.demo.service.PersonService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonController.class)
class PersonControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PersonService personService;
	
	/**
	 * Comparing response as json
	 * @throws Exception
	 */
	@Test
	void testGetYoungest() throws Exception {
		Person personExpected = new Person("Vipul", "Pai", LocalDate.of(1997, 3, 8));
		when(personService.getYoungest()).thenReturn(personExpected);
		mvc.perform(get("/persons/youngest"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value(personExpected.getFirstName()))
				.andExpect(jsonPath("$.lastName").value(personExpected.getLastName()))
				.andExpect(jsonPath("$.dateOfBirth").value(personExpected.getDateOfBirth().toString()));
	}
}
