package com.codingdojo.servicios;

import java.util.List;


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
	
}
