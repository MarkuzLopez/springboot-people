package com.example.demo.dto;

import lombok.Data;

@Data
public class LoginRequest {
	/**
	 * DTO for login request
	 * @username: user's username
	 * @password: user's password
	 */
	private String username;
	private String password;	
}
