package com.example.demo.dto;

import com.example.demo.share.JakartaConstants;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

// usar mejor los getters y setters 

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

	//TODO: 
	@NotNull(message = JakartaConstants.NULL_NAME_MESSAGE )
	@Size(min= JakartaConstants.INT_2, max = JakartaConstants.INT_50, message = JakartaConstants.NAME_RESPONSE_MESSAGE)
	@Pattern(regexp = JakartaConstants.REGEX_NAME, message = JakartaConstants.NAME_RESPONSE_INVALID)    
	private String nombre;
	
	@Min( value = JakartaConstants.INT_18, message = JakartaConstants.MESSAGE_AGE_MINIUM)	
	@Max( value= JakartaConstants.INT_100, message = JakartaConstants.MESSAGE_AGE_MAX)
	private int edad;
	
}
