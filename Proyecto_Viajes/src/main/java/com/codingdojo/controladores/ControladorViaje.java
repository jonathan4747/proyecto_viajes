package com.codingdojo.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String PaginaPrincipal(@Valid @ModelAttribute("viaje") Viaje nuevoViaje,BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Viaje> listaViajes =  servicioViaje.SelectAllViajes();
			model.addAttribute("listaViajes", listaViajes);
			return "index.jsp";
		}
		else {
			servicioViaje.CreateViaje(nuevoViaje);
			
			return "redirect:/expenses";
		}
	}
	@RequestMapping( value = "/expenses/edit/{id}", method = RequestMethod.GET )
	public String Ver(@PathVariable("id") Long id,@ModelAttribute("viaje") Viaje editarViaje,HttpSession session) {
		editarViaje = servicioViaje.EncontrarId(id);
		session.setAttribute("id", editarViaje.getId());
		session.setAttribute("nombregasto", editarViaje.getNombregasto());
		session.setAttribute("vendedor", editarViaje.getVendedor());
		session.setAttribute("monto", editarViaje.getMonto());
		session.setAttribute("descripcion", editarViaje.getDescripcion());
		return"edit.jsp";
	}
	
	@RequestMapping( value = "/logout", method = RequestMethod.GET )
	public String logout( HttpSession session ) {
		session.removeAttribute( "id" );
		session.removeAttribute( "nombregasto" );
		session.removeAttribute( "vendedor" );
		session.removeAttribute( "monto" );
		session.removeAttribute( "descripcion" );
		
		return "redirect:/expenses";
	}
	@RequestMapping( value = "/expenses/edit/{id}", method = RequestMethod.PUT )
	public String editarViaje( @Valid @ModelAttribute("viaje") Viaje editarViaje, BindingResult result,
								 HttpSession session) {
		if ( result.hasErrors() ) {
			return "edit.jsp";
		}
		else {
			session.setAttribute("nombregasto", editarViaje.getNombregasto());
			session.setAttribute("vendedor",editarViaje.getVendedor());
			session.setAttribute("monto", editarViaje.getMonto());
			session.setAttribute("descripcion", editarViaje.getDescripcion());
			servicioViaje.updateViaje(editarViaje);
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping( value = "/expenses/eliminar/{id}", method = RequestMethod.DELETE )
	public String eliminarGasto( @PathVariable("id") long id ) {
		servicioViaje.deleteFromId(id);
		return "redirect:/expenses";
	}
	
	@RequestMapping( value = "/expenses/{id}", method = RequestMethod.GET )
	public String Ver(@PathVariable("id") Long id,HttpSession session) {
		Viaje viaje = servicioViaje.EncontrarId(id);
		session.setAttribute("nombregasto", viaje.getNombregasto());
		session.setAttribute("vendedor",viaje.getVendedor());
		session.setAttribute("monto", viaje.getMonto());
		session.setAttribute("descripcion", viaje.getDescripcion());
		return "vista.jsp";
	}
}

