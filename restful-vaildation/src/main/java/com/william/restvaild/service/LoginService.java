package com.william.restvaild.service;

import com.william.restvaild.controller.dto.req.LoginRequest;
import com.william.restvaild.controller.dto.res.LoginResponse;
import com.william.restvaild.util.rest.RestfulResponse;

public interface LoginService {

	public RestfulResponse<LoginResponse> loginByEmailAndPassword(LoginRequest request);
	
}
