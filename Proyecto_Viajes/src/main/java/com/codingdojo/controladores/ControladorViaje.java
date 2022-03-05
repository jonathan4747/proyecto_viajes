package com.codingdojo.controladores;

import java.util.List;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.codingdojo.modelos.Viaje;
import com.codingdojo.servicios.ServicioViaje;

@Controller
public class ControladorViaje {
	private ServicioViaje servicioViaje;
	public ControladorViaje (ServicioViaje servicioViaje) {
		this.servicioViaje=servicioViaje;
	}
	
	@RequestMapping( value = "/expenses", method = RequestMethod.GET )
	public String PaginaPrincipal(@ModelAttribute("viaje") Viaje nuevoViaje,Model model) {
		List<Viaje> listaViajes =  servicioViaje.SelectAllViajes();
		model.addAttribute("listaViajes", listaViajes);
		return "index.jsp";
	}
	@RequestMapping( value = "/expenses", method = RequestMethod.POST )
	public String PaginaPrincipal(@Valid @ModelAttribute("viaje") Viaje nuevoViaje,BindingResult result) {
		System.out.println("esto es el nuvo gasto "+nuevoViaje.getNombregasto());
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			servicioViaje.CreateViaje(nuevoViaje);
			
			return "redirect:/expenses";
		}
	}
	
}
