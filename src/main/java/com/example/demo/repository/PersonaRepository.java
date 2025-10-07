package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Persona;
/**
 * PASO 4 Crear repository, implementando interface usando JPA
 */
/**
 * En Spring Data JPA, un repositorio es una interfaz que permite acceder 
 * y manipular datos en la base de datos.
 * 
 * CrudRepository: Proporciona operaciones CRUD (Create, Read, Update, Delete).
 * metodos principales: save(S entity) → guarda o actualiza una entidad.	
	- findById(ID id) → busca un registro por ID.	
	- findAll() → devuelve todos los registros.	
	- deleteById(ID id) → elimina un registro por ID.	
	- count() → devuelve el número de registros.
	- existsById(ID id) → comprueba si existe un registro con un ID específico.
 * 	
 * JpaRepository: Extiende de CrudRepository y PagingAndSortingRepository.
 * Agrega más funcionalidades, como paginación, ordenación y consultas personalizadas.
  	- findAll(Sort sort) → devuelve todos los registros con ordenamiento.
  	- findAll(Pageable pageable) → devuelve resultados paginados.
	- flush() → sincroniza con la base de datos inmediatamente.
	- saveAndFlush(entity) → guarda y hace flush.
	- deleteAllInBatch() → elimina en lote.
 */

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	  // 🔹 Consulta con JPQL (usa nombres de entidades, no tablas)
    	@Query("SELECT p FROM Persona p Where p.edad > :edad")
    	List<Persona> buscarMayoresDe(@Param("edad") int edad);
    	
    	// consulta coj like busqueda parcial
    	@Query("SELECT p From Persona p WHERE p.nombre LIKE %:nombre%")
    	List<Persona> buscarPorNombre(@Param("nombre") String nombre );
    	
    	//Contar personas por edad 
    	@Query("SELECT COUNT(p) FROM Persona p WHERE p.edad =:edad ")
    	long contarPorEdad(@Param("edad") int edad);
    	
}
