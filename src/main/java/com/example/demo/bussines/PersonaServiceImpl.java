package com.example.demo.bussines;

import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;
import com.example.demo.dto.*;
import com.example.demo.model.Persona;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



/**
 * PASO 5 crear repository el cual realiza  las acciones de CRUD 
 * usando model, y repository 
 */

@Service
public class PersonaServiceImpl implements PersonaService {
	
	private final PersonaRepository repository;
	
	public PersonaServiceImpl(final PersonaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<PersonaResponseDTO>listar() {
		return repository.findAll()
				.stream()
				.map(p -> new  PersonaResponseDTO(p.getNombre(), p.getEdad()))
				.collect(Collectors.toList());
	}
	
	@Override
	public Optional<PersonaResponseDTO> buscarPorId(Long id){
		return repository.findById(id)
				.map(p -> new PersonaResponseDTO(p.getNombre(), p.getEdad()));
	}
	
	@Override
	public Persona guardar(PersonaDTO dto) {
		Persona persona =  new Persona();
		persona.setNombre(dto.getNombre());
		persona.setEdad(dto.getEdad());
		return repository.save(persona);
	}
	
	@Override
	public Persona update(Long id, PersonaDTO dto) { 
		return repository.findById(id).map( p ->  {
			p.setNombre(dto.getNombre());
			p.setEdad(dto.getEdad());
			Persona updated =  repository.save(p);			
			return new Persona(id, updated.getNombre(), updated.getEdad());
		}).orElseThrow(() -> new RuntimeException("Persona con id" + id + "no encontrada"));
	}
	
	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}
	
	// consultas con SQL @Queries 
	@Override
	public List<Persona> mayoresDeEdad(int edad){
		return repository.buscarMayoresDe(edad);
	}
	
	@Override
	public List<Persona> buscarPorNombre(String nombre){
		return repository.buscarPorNombre(nombre);
	}
	
	@Override
	public long contarPorEdad(int edad) {
		return repository.contarPorEdad(edad);
	}
	
}
