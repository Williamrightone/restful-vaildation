package com.william.restvaild.service.impl;

import org.springframework.stereotype.Service;

import com.william.restvaild.controller.dto.req.LoginRequest;
import com.william.restvaild.controller.dto.res.LoginResponse;
import com.william.restvaild.service.LoginService;
import com.william.restvaild.util.rest.RestfulResponse;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public RestfulResponse<LoginResponse> loginByEmailAndPassword(LoginRequest request) {
		
		LoginResponse response = new LoginResponse();
		
		response.setUserId(1L);
		response.setUserName("william");
		
		return new RestfulResponse<LoginResponse>(response);
	}

}
