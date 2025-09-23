package com.example.demo.service;

import com.example.demo.repository.PersonaRepository;
import com.example.demo.dto.PersonaDTO;
import com.example.demo.model.Persona;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * PASO 5 crear repository el cual realiza  las acciones de CRUD 
 * usando model, y repository 
 */

@Service
public class PersonaService {
	
	private final PersonaRepository repository;
	
	public PersonaService(PersonaRepository repository) {
		this.repository = repository;
	}
	
	public List<Persona>listar() {
		return repository.findAll();
	}
	
	public Optional<Persona> buscarPorId(Long id){
		return repository.findById(id);
	}
	
	public Persona guardar(PersonaDTO dto) {
		Persona persona =  new Persona();
		persona.setNombre(dto.getNombre());
		persona.setEdad(dto.getEdad());
		return repository.save(persona);
	}
	
	public Persona update(Long id, PersonaDTO dto) { 
		return repository.findById(id).map( p ->  {
			p.setNombre(dto.getNombre());
			p.setEdad(dto.getEdad());
			return repository.save(p);
		}).orElseThrow(() -> new RuntimeException("persona no encontrada"));
	}
	
	public void eliminar(Long id) {
		repository.deleteById(id);
	}
	
	// consultas con SQL @Queries 
	public List<Persona> mayoresDeEdad(int edad){
		return repository.buscarMayoresDe(edad);
	}
	public List<Persona> buscarPorNombre(String nombre){
		return repository.buscarPorNombre(nombre);
	}
	public long contarPorEdad(int edad) {
		return repository.contarPorEdad(edad);
	}
}
