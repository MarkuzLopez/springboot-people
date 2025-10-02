package com.example.demo.dto;

import lombok.Data;

@Data
public class RegisterRequest {
	/**
	 * register request dto
	 * username and password	 
	 */
	private String username;
	private String password;
}
