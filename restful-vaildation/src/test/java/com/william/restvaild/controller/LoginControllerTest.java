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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.william.restvaild.controller.dto.req.LoginRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
	
	private static final String LOGIN_URI = "/login/validation";
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test_login_email_is_null() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post(LOGIN_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new LoginRequest(null,"Demo1234")));
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("00001"))
				.andExpect(jsonPath("$.errMessage").value("email can not be null"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_email_is_blank() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post(LOGIN_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new LoginRequest("","Demo1234")));
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("00001"))
				.andExpect(jsonPath("$.errMessage").value("email can not be null"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_password_is_null() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post(LOGIN_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new LoginRequest("willy4543@gmail.com",null)));
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("00001"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_password_is_blank() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post(LOGIN_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new LoginRequest("willy4543@gmail.com","")));
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("00001"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_password_too_short() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post(LOGIN_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new LoginRequest("willy4543@gmail.com","aaa")));
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("00001"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_password_too_long() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post(LOGIN_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new LoginRequest("willy4543@gmail.com","1Qaz2wsx3eDc4rfv")));
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("00001"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_password_format_error() throws Exception {
		
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post(LOGIN_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new LoginRequest("willy4543@gmail.com","'OR 1=1 --")));
		
		mockMvc.perform(requestbuilder)
				.andDo(print())
				.andExpect(jsonPath("$.customErrorCode").value("00001"))
				.andExpect(status().is(400));
	}
	
	@Test
	void test_login_success() throws Exception {
		RequestBuilder requestbuilder = MockMvcRequestBuilders
				.post(LOGIN_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new LoginRequest("willy4543@gmail.com","Demo1234")));
		
		mockMvc.perform(requestbuilder)
		.andDo(print())
		.andExpect(jsonPath("$.data.email").value("willy4543@gmail.com"))
		.andExpect(status().is(200));
	}
	
	

}
