package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;


/**
 * Utilidad para manejar JSON Web Tokens (JWT).
 * Proporciona métodos para generar, validar y extraer información de los tokens JWT.
 * Utiliza la biblioteca jjwt para la creación y verificación de tokens.
 * La clave secreta y el tiempo de expiración están definidos como constantes.
 * El token incluye el nombre de usuario y el rol como reclamos.
 * El token se firma utilizando el algoritmo HS256.
 * El tiempo de expiración del token es de una hora.
 */


@Component
public class JwtUtil {
	
	private static final String SECRET_KEY = "¡MiClaveSuperSecretaParaJWTConSpringBoot2025";
	private static final long EXPIRATION_TIME = 1000 * 60 * 60; // una hora
	
	private Key getSigningKey() {
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}
	
	public String generateToken(String username, String role) {
		return Jwts.builder()
				.setSubject(username)
				.claim(username, role)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME ))
				.signWith(getSigningKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public String extractUsername(String token) { 
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public String extractRole(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.get("rolw", String.class);
	}
	
	public boolean isTokenValid(String token) {
		try {
			Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token);
			return true;
		} catch (JwtException e) {
			return false;
		}
	}
	
}
