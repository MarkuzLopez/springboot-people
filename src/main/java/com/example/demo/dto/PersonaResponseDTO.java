package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaResponseDTO {
	
	private String nombre;
	private int edad;
}
