package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data 	  				// lombook: getter, settter, toString
public class PersonaDTO {


	/**
	 * OTRAS NOTACIONES DE VALIDACION
	 * @NotBlank → para cadenas no vacías.
	 * @Pattern(regexp = "...") → para validar con expresiones regulares.
	 * @Positive, @PositiveOrZero → para números positivos.
	 * @Negative, @NegativeOrZero → para números negativos.
	 * @Past, @Future → para fechas.
	 * @AssertTrue, @AssertFalse → para booleanos.
	 */

	@NotNull(message = "El nombre no puede ser  nulo")
	@Size(min= 2, max = 50, message = "El nombre denbe tener entre 2 y 50 caracteres")
	@Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ'\\-]*$", message = "El nombre no es válido")    
	private String nombre;
	
	@Min( value = 18, message = "la edad minima es 18")	
	@Max( value= 100, message = "la edad maxima es 100")
	private int edad;
	
}
