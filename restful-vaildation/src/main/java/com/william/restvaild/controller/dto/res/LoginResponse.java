package com.william.restvaild.controller.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	
	private String email;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userName;

}
