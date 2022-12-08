package com.william.restvaild.controller.dto.req;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

	@NotBlank(message = "email can not be null")
	private String email;
	
	@NotBlank(message = "password can not be null")
	private String password;
	
}
