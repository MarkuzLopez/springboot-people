package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.JwtAuthenticationFilter;

/**
 * configuración de seguridad para la aplicación.
 * Define las reglas de seguridad, los filtros y los manejadores de autenticación.
 * Utiliza JWT para la autenticación sin estado.
 * Permite el acceso público a ciertas rutas y protege otras.
 * Configura un codificador de contraseñas para la seguridad de las credenciales.
 * Gestiona las sesiones de manera que no se mantenga el estado.
 * Integra un filtro personalizado para manejar la autenticación basada en JWT.
 */

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtFilter;
    
    /**
     * Configura la cadena de filtros de seguridad.
     * Desactiva CSRF para simplificar las solicitudes API.
     * Define las reglas de autorización para las rutas.
     * Configura la gestión de sesiones para que sea sin estado.
     * Añade un filtro personalizado para manejar la autenticación JWT.
     */

    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // descativa cORS
            .cors(cors -> {}) // habilita CORS con la configuacion de arriba
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/public/**").permitAll()
                .requestMatchers("/api/personas/**").authenticated()
                .anyRequest().permitAll()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
