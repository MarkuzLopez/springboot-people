package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.*;
import com.example.demo.model.Usuario;
import com.example.demo.security.JwtUtil;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	private JwtUtil jwtUtil;
	
	/**
	 * Endpoint para registrar un nuevo usuario.
	 * @param request Datos del usuario a registrar.
	 * @return Respuesta indicando el éxito o fracaso del registro.
	 */
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (usuarioRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuario ya existe");
        }

        Usuario usuario = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("ROLE_USER")
                .build();

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }
	
	/**
	 * Endpoint para autenticar un usuario.
	 * @param request Datos del usuario para autenticación.
	 * @return Token JWT si la autenticación es exitosa.
	 * @throws RuntimeException si el usuario no es encontrado o la contraseña es incorrecta.
	 */


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		/**
		 * Verifica la contraseña proporcionada con la almacenada en la base de datos.
		 * Si la contraseña no coincide, devuelve una respuesta de error.
		 * Si la contraseña es correcta, genera un token JWT y lo devuelve en la respuesta.
		 * 
		 */

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            return ResponseEntity.badRequest().build();
        }

        String token = jwtUtil.generateToken(usuario.getUsername(), usuario.getRole());
        return ResponseEntity.ok(new AuthResponse(token));
    }
	
}
