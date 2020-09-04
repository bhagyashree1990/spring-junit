package com.bhagyashree.junit.demo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;

import com.bhagyashree.junit.demo.config.CustomRestDocsConfiguration;
import com.bhagyashree.junit.demo.model.Person;
import com.bhagyashree.junit.demo.service.PersonService;


@WebMvcTest(controllers = PersonController.class)
@AutoConfigureRestDocs
@Import({CustomRestDocsConfiguration.class})
class PersonControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PersonService personService;
	
	private FieldDescriptor[] personDescriptor = new FieldDescriptor[] {
			fieldWithPath("firstName").description("First Name"),
			fieldWithPath("lastName").description("Last Name"),
			fieldWithPath("dateOfBirth").description("Date of Birth")
	};
	
	/**
	 * Comparing response as json
	 * @throws Exception
	 */
	@Test
	void testGetYoungest() throws Exception {
		Person personExpected = new Person("Vipul", "Pai", LocalDate.of(1997, 3, 8));
		when(personService.getYoungest()).thenReturn(personExpected);
		mvc.perform(get("/persons/youngest"))
				.andDo(
					document("{class-name}/{method-name}",responseFields(personDescriptor)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value(personExpected.getFirstName()))
				.andExpect(jsonPath("$.lastName").value(personExpected.getLastName()))
				.andExpect(jsonPath("$.dateOfBirth").value(personExpected.getDateOfBirth().toString()));
	}
	
	
	@Test
	void testFindAll() throws Exception {
		Person person1 = new Person("Vipul", "Pai", LocalDate.of(1997, 3, 8));
		Person person2 = new Person("Bhagyashree","Chavan",LocalDate.of(1990, 4, 1));
		List<Person> persons = Arrays.asList(person1,person2);
		when(personService.findAll()).thenReturn(persons);
		mvc.perform(get("/persons"))
				.andDo(document("{class-name}/{method-name}", 
						responseFields(fieldWithPath("[]").description("Array of persons"))
							.andWithPrefix("[].", personDescriptor)
					))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)));
	}
}
