package com.bhagyashree.junit.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bhagyashree.junit.demo.service.GreetingService;
@WebMvcTest(controllers = GreetingController.class)
@AutoConfigureRestDocs
class GreetingControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private GreetingService greetingService;
	
	/**
	 * Comparing String response
	 * @throws Exception
	 */
	@Test
	void testHello() throws Exception {
		when(greetingService.greetHello("World")).thenReturn("Hello World");
		mvc.perform(get("/greeting/hello"))
			.andDo(print())
			.andExpect(content().string("Hello World"));
	}
	
	/**
	 * Comparing String response
	 * @throws Exception
	 */
	@Test
	void testHelloWithName() throws Exception {
		when(greetingService.greetHello("John")).thenReturn("Hello John");
		mvc.perform(get("/greeting/hello?name=John"))
			.andDo(
					document("greeting",
						requestParameters(
							parameterWithName("name").description("The name to greet")
						)))
			.andExpect(content().string("Hello John"));
	}
}
