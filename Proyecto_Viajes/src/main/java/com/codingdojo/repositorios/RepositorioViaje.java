package com.codingdojo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.modelos.Viaje;
@Repository
public interface RepositorioViaje extends CrudRepository<Viaje , Long> {
	List<Viaje> findAll();
	
	@SuppressWarnings("unchecked")
	Viaje save( Viaje nuevoViaje );
}
