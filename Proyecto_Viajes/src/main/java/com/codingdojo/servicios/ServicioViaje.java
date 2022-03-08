package com.codingdojo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Viaje;
import com.codingdojo.repositorios.RepositorioViaje;

@Service
public class ServicioViaje {
	
	private RepositorioViaje repositorioViaje;
	public ServicioViaje (RepositorioViaje repositorioViaje) {
		this.repositorioViaje=repositorioViaje;
	}
	//leer todos los gastos
	public List<Viaje> SelectAllViajes(){
		return repositorioViaje.findAll();
	}
	//crear un gasto
	public Viaje CreateViaje(Viaje nuevoViaje) {
		return repositorioViaje.save(nuevoViaje);
	}
	//Encontrar el id para la edicion y para verlo
	public Viaje EncontrarId(Long id) {
		Optional<Viaje> opotionalViaje=repositorioViaje.findById(id); 
		if(opotionalViaje.isPresent()) {
			return opotionalViaje.get(); 
		} 
		else {
			return null;
		}
	}
	//Editar
	public void updateViaje( Viaje editarViaje ) {
		
		repositorioViaje.actualizaviaje( editarViaje.getNombregasto(), 
										 editarViaje.getVendedor(), 
										 editarViaje.getMonto(), 
										 editarViaje.getDescripcion(),
										 editarViaje.getId()
										  ); 								   
	}
	//Eliminar
	public Long deleteFromId( long id ) {
		return repositorioViaje.deleteById(id);
	}
	
}
