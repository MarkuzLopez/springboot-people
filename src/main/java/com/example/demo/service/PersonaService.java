package com.example.demo.service;

import com.example.demo.repository.PersonaRepository;
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
	
	public Persona guarar(Persona persona) {
		return repository.save(persona);
	}
	
	public void eliminar(Long id) {
		repository.deleteById(id);
	}
}
