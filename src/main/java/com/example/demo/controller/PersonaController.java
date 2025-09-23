package com.example.demo.controller;

import com.example.demo.service.PersonaService;

import jakarta.validation.Valid;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * POASO 6 crear el controller, quien es el encargado de 
 * realizar conexion con el service para las peticiones y 
 * quien realiza el request mapping URLs para consumir apis
 */

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
	
	@Autowired
	private final PersonaService service;
	
	public PersonaController(PersonaService service) {
		this.service = service;
	}
	
	// GET: Listar todas personas
	@GetMapping("/all")
	public ResponseEntity<List<Persona>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST: Crear nueva persona
	@PostMapping
	public ResponseEntity<Persona> crear(@Valid  @RequestBody PersonaDTO dto){
		//return ResponseEntity.ok(service.guardar(persona));
		return ResponseEntity.ok(service.guardar(dto));
	}
	
	// PUT Actualizar persona
	@PutMapping("/{id}")
	public ResponseEntity<Persona> actualizar(@PathVariable Long id, @Valid
											@RequestBody PersonaDTO dto ){
		return ResponseEntity.ok(service.update(id, dto));
	}
	
	 // DELETE: Eliminar persona
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(p -> {
                    service.eliminar(id);
                    return ResponseEntity.status(HttpStatus.OK).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // controladores co Queries SQL
    @GetMapping("/mayores/{edad}")
    public List<Persona> mayoresDe(@PathVariable int edad) {
    	return service.mayoresDeEdad(edad);
    }
    @GetMapping("/buscar/{nombre}")
    public List<Persona> buscarNombre(@PathVariable String nombre){
    	return service.buscarPorNombre(nombre);
    }
    @GetMapping("/contar/{edad}")
    public long contarEdad(@PathVariable int edad) {
    	return service.contarPorEdad(edad);
    }
	
}
