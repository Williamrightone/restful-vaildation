package com.william.restvaild.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.william.restvaild.controller.dto.req.LoginRequest;
import com.william.restvaild.util.handler.CustomServiceException;

@SpringBootTest
public class LoginServiceTest {
	
	@Autowired
	private LoginService loginService;

	@Test
	void test_when_user_not_found_that_throw_exception() {
		
		CustomServiceException customServiceException = assertThrows(CustomServiceException.class, ()-> {
			loginService.loginByEmailAndPassword(new LoginRequest("peter123@gmail.com","Demo1234"));			
		});
		
		assertEquals("10000", customServiceException.getErrorCode());
		
	}
	
	@Test
	void test_when_email_and_password_not_match_that_throw_exception() {
		
		CustomServiceException customServiceException = assertThrows(CustomServiceException.class, ()-> {
			loginService.loginByEmailAndPassword(new LoginRequest("willy4543@gmail.com","Abc1234"));			
		});
		
		assertEquals("10001", customServiceException.getErrorCode());
		
	}
	
	//TODO 測試預期結果


}
