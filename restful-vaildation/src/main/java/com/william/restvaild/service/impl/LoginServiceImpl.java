package com.william.restvaild.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.william.restvaild.controller.dto.req.LoginRequest;
import com.william.restvaild.controller.dto.res.LoginResponse;
import com.william.restvaild.repos.dao.UserEntityRepository;
import com.william.restvaild.repos.po.UserEntity;
import com.william.restvaild.service.LoginService;
import com.william.restvaild.util.handler.CustomServiceException;
import com.william.restvaild.util.handler.CustomServiceException.CustomServiceErrorType;
import com.william.restvaild.util.rest.RestfulResponse;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserEntityRepository userEntityRepsoitory;
	
	@Autowired
	private PasswordEncoder bCrypt;

	@Override
	public RestfulResponse<LoginResponse> loginByEmailAndPassword(LoginRequest request) {
		
		UserEntity userEntity = userEntityRepsoitory.findByEmail(request.getEmail())
				.orElseThrow(() -> new CustomServiceException(CustomServiceErrorType.USER_NOT_FOUND, "User Not Found"));
		
		if(!bCrypt.matches(request.getPassword(), userEntity.getPassword())) {

			throw new CustomServiceException(CustomServiceErrorType.EMAIL_PASSWORD_NOT_MATCH,
					"Email and Password Do Not Match");
		}

		LoginResponse response = new LoginResponse();

		response.setEmail(userEntity.getEmail());
		response.setUserName(userEntity.getUserName());

		return new RestfulResponse<LoginResponse>(response);
	}

}
