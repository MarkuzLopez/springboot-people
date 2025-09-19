package com.example.demo.model;

import jakarta.persistence.*;
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
	
	@Column(nullable = false, length = 100) // Opcional: para personalizar columna
	private String nombre;
	private int edad;	
}
