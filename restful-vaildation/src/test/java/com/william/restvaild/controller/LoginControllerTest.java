package com.william.restvaild.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test_login_email_is_null() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post("/login/validation")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"email\":\"\",\r\n"
						+ "    \"password\":\"Demo1234\"\r\n"
						+ "}");
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("8000"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_password_is_null() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post("/login/validation")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"email\":\"willy4543@gmail.com\",\r\n"
						+ "    \"password\":\"\"\r\n"
						+ "}");
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("8000"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_password_too_short() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post("/login/validation")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"email\":\"willy4543@gmail.com\",\r\n"
						+ "    \"password\":\"a123\"\r\n"
						+ "}");
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("8000"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_password_too_long() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post("/login/validation")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"email\":\"willy4543@gmail.com\",\r\n"
						+ "    \"password\":\"a123456789qazwsx\"\r\n"
						+ "}");
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("8000"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_password_format_error() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post("/login/validation")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"email\":\"willy4543@gmail.com\",\r\n"
						+ "    \"password\":\"'OR 1=1 --\"\r\n"
						+ "}");
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("8000"))
				.andExpect(status().is(400));
	}
	
	

}
