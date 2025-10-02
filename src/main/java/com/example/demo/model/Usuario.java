package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * Clase que representa a un usuario en el sistema.
 * Contiene información básica como nombre de usuario, contraseña y rol.
 * Utiliza anotaciones de JPA para mapear la clase a una tabla de base de datos.
 * Utiliza Lombok para generar automáticamente getters, setters, constructores y el patrón builder.
 * 
 */


public class Usuario {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	private String role; // ej: "ROLE_USER", "ROLE_ADMIN"
	
}
