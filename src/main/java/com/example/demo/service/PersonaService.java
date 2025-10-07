package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.PersonaResponseDTO;
import com.example.demo.model.Persona;

//TODO:  metodoso de acceso investigar

//TODO:  que s una interfaz y posibles usos
public interface PersonaService {

	// metodos que se van a implementar 
	 List<PersonaResponseDTO>listar(); //firmas de los conratos
	 Optional<PersonaResponseDTO> buscarPorId(Long id);
	 Persona guardar(PersonaDTO dto);
	 Persona update(Long id, PersonaDTO dto);
	 void eliminar(Long id);
	 List<Persona> mayoresDeEdad(int edad);
	 List<Persona> buscarPorNombre(String nombre);
	 long contarPorEdad(int edad);
}
