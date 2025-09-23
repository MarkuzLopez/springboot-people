package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

/** 
 * PASO 3 CREAR ENTIDAD PERSONA USANDO LOOMBOK EVITANDO boilerplate
 * @Entity: clase Java que representa una tabla en la base de datos.
 * Se marca con la anotación @Entity para que JPA/Hibernate la reconozca.
 * **/

@Entity
@Table(name = "personas")
@Data 	  				// lombook: getter, settter, toString
@NoArgsConstructor  	// Constructor vacio
@AllArgsConstructor 	// Constructor con tofoso los campos

public class Persona {
	/**
	 * @Id: Este campo será el identificador único de cada registro en la tabla.
	 * @@GeneratedValue: para indicar cómo se generan los valores del @Id.
	 * Comúnmente se usa para que la base de datos asigne un valor auto incremental.
	 * @GenerationType.IDENTITY: -> Delega la generación al motor de BD (ejemplo: MySQL autoincrement).
	 * @GenerationType.SEQUENCE → Usa una secuencia (más común en Oracle/PostgreSQL).
	 * @GenerationType.AUTO → Hibernate elige automáticamente la estrategia según la BD.
	 */
	
	@Id // clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //  auto incremental
	private Long id;
	
	
	@NotNull(message = "El nombre no puede ser  nulo")
	@Size(min= 2, max = 50, message = "El nombre denbe tener entre 2 y 50 caracteres")
	@Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ'\\-]*$", message = "El nombre no es válido")    
	private String nombre;
	
	@Min( value = 18, message = "la edad minima es 18")	
	@Max( value= 100, message = "la edad maxima es 100")
	private int edad;
}
