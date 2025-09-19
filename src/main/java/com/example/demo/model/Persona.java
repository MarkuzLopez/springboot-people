package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

/** 
 * PASO 3 CREAR ENTIDAD PERSONA USANDO LOOMBOK EVITANDO boilerplate
 * **/

@Entity
@Data 	  				// lombook: getter, settter, toString
@NoArgsConstructor  	// Constructor vacio
@AllArgsConstructor 	// Constructor con tofoso los campos

public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private int edad;	
}
