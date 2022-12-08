package com.william.restvaild.controller.dto.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

	@NotBlank(message = "email can not be null")
	private String email;
	
	@Size(min = 6, max = 12, message = "length of password should between 6 and 12")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "password format error")
	@NotBlank(message = "password can not be null")
	private String password;
	
}
