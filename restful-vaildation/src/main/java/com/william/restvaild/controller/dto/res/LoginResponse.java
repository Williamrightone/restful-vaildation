package com.william.restvaild.controller.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	
	private Long userId;
	
	private String userName;
	
	private String accessToken;
	
	private String refreshToken;

}