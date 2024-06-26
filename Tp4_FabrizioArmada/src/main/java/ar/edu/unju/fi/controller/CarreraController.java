package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListaCarrera;
import ar.edu.unju.fi.model.Carrera;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/carrera")
public class CarreraController {
    @Autowired
    private Carrera carrera;
	
	@GetMapping("/listado")
	public String getCarrerasPage(Model model){
		model.addAttribute("carreras",ListaCarrera.listarCarreras());
		return "carreras";
	}
	 
	@GetMapping("/nuevo")
	public String getCarrerasFormPage(Model model) {
		boolean edicion=false;
		model.addAttribute("carrera",carrera);
		model.addAttribute("edicion",edicion);
		return "carrerasForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarCarrerasPage(@Valid @ModelAttribute("carrera") Carrera carrera, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("carrerasForm");
		}else {
			modelView = new ModelAndView("carreras");
			carrera.setEstado(true);
			ListaCarrera.agregarCarrera(carrera);
			modelView.addObject("carreras", ListaCarrera.listarCarreras());
		}
		
		return modelView;
	}
	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="codigo") int codigo) {
		Carrera encontrado = new Carrera();
		boolean edicion=true;
		encontrado=ListaCarrera.buscarCarreras(codigo);
		model.addAttribute("edicion",edicion);
		model.addAttribute("carrera",encontrado);
		return "carrerasForm";
	}
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		ListaCarrera.modificarCarrera(carrera);
		return "redirect:/carrera/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") int codigo) {
		ListaCarrera.eliminarCarrera(codigo);
		return "redirect:/carrera/listado";
	}
	
	
}
