package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	/**
	 * Configuración de CORS para permitir solicitudes desde el frontend (Angular, React)
	 * Ajusta los orígenes permitidos según sea necesario
	 * @return WebMvcConfigurer con configuración CORS personalizada
	 * 
	 */
	@Bean
	WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // aplicar a todos los endpoints
                        .allowedOrigins("http://localhost:4200", "http://localhost:3000") // Angular, React
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
