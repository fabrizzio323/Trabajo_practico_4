package ar.edu.unju.fi.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import ar.edu.unju.fi.collections.ListaCarrera;
import ar.edu.unju.fi.dto.CarreraDTO;
//import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.service.ICarreraService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/carrera")
public class CarreraController {
  
	/*@Autowired
    private Carrera carrera;*/
	
	@Autowired
	private CarreraDTO carreraDTO;
    
    @Autowired
    private ICarreraService iCarreraService;
	
	@GetMapping("/listado")
	public String getCarrerasPage(Model model){
		model.addAttribute("carreras",iCarreraService.listaCarreras());
		return "carreras";
	}
	 
	@GetMapping("/nuevo")
	public String getCarrerasFormPage(Model model) {
		boolean edicion=false;
		//model.addAttribute("carrera",carrera);
		model.addAttribute("carrera",carreraDTO);
		model.addAttribute("edicion",edicion);
		return "carrerasForm";
	}
	
	@PostMapping("/guardar")
	//public ModelAndView getGuardarCarrerasPage(@Valid @ModelAttribute("carrera") Carrera carrera, BindingResult result) {
	public ModelAndView getGuardarCarrerasPage(@Valid @ModelAttribute("carrera") CarreraDTO carreraDTO, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("carrerasForm");
		}else {
			modelView = new ModelAndView("carreras");
			//carrera.setEstado(true);
			carreraDTO.setEstado(true);
			//ListaCarrera.agregarCarrera(carrera);
			iCarreraService.crearCarrera(carreraDTO);
			//modelView.addObject("carreras", ListaCarrera.listarCarreras());
			modelView.addObject("carreras", iCarreraService.listaCarreras());
		}
		
		return modelView;
	}
	@GetMapping("/modificar/{id}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="id") Long id) {
		//Carrera encontrado = new Carrera();
		CarreraDTO encontrado = new CarreraDTO();
		boolean edicion=true;
		//encontrado=ListaCarrera.buscarCarreras(codigo);
		encontrado=iCarreraService.buscarCarrera(id);
		model.addAttribute("edicion",edicion);
		model.addAttribute("carrera",encontrado);
		return "carrerasForm";
	}
	@PostMapping("/modificar")
	//public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera) {
	public String modificarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO) throws Exception {
		//ListaCarrera.modificarCarrera(carrera);
		iCarreraService.modificarCarrera(carreraDTO);
		return "redirect:/carrera/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="id") Long id) {
		//ListaCarrera.eliminarCarrera(codigo);
		iCarreraService.eliminarCarrera(id);
		return "redirect:/carrera/listado";
	}
	
	
}
