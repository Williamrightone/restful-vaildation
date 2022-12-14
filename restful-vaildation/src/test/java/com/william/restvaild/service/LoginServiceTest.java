package com.william.restvaild.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.william.restvaild.controller.dto.req.LoginRequest;
import com.william.restvaild.repos.dao.UserEntityRepository;
import com.william.restvaild.repos.po.UserEntity;
import com.william.restvaild.util.handler.CustomServiceException;

@SpringBootTest
public class LoginServiceTest {
	
	@Autowired
	private LoginService loginService;
	
	@MockBean
	private UserEntityRepository userEntityRepository;

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
	
	@Test
	void test_mock_when_user_exist() {
		
		Optional<UserEntity> mockUser = Optional.ofNullable(new UserEntity());
		mockUser.get().setEmail("willy4543@gmail.com");
		
		Mockito.when(userEntityRepository.findByEmail("willy4543@gmail.com")).thenReturn(mockUser);
		
		assertNotNull(mockUser);
		assertEquals("willy4543@gmail.com", mockUser.get().getEmail());
		
	}
	
	
	
	
	
	
	
	

}
