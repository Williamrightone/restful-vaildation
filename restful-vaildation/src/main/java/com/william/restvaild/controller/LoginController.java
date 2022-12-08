package com.william.restvaild.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.restvaild.controller.dto.req.LoginRequest;
import com.william.restvaild.controller.dto.res.LoginResponse;
import com.william.restvaild.service.LoginService;
import com.william.restvaild.util.rest.RestfulResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/login")
@Validated
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@ApiOperation(value = "vaildate password", tags = { "Login" })
	@PostMapping("/validation")
	public RestfulResponse<LoginResponse> vaildPassword(@Valid @RequestBody LoginRequest request){
		
		return loginService.loginByEmailAndPassword(request);
	}

}
