package com.example.demo.share;

//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;

// // @NoArgsConstructor(access = AccessLevel.PRIVATE) /// para tener constrcutor privado y vacio
public final class JakartaConstants {
	private JakartaConstants() {		
	}
	
	//TODO primitivos y wrappers (investigar)
	//TODO: string utils de apache commons 
	public static final String NULL_NAME_MESSAGE="El nombre no puede ser  nulo";
	public static final int INT_2=2;
	public static final int INT_50=50;
	public static final String NAME_RESPONSE_MESSAGE="El nombre denbe tener entre 2 y 50 caracteres";
	public static final String REGEX_NAME="^[A-Za-zÀ-ÖØ-öø-ÿ'\\\\-]*$";
	public static final String NAME_RESPONSE_INVALID ="el nombre no es valdo";
	public static final int INT_18=18;
	public static final int INT_100=100;
	public static final String MESSAGE_AGE_MINIUM="la edad minima es 18";
	public static final String MESSAGE_AGE_MAX="la edad maxima es 100";
	
}
