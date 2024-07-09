package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.imp.DocenteServiceImp;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/docente")
public class DocenteController {
 
	@Autowired
	private DocenteDTO docenteDTO;
	@Autowired	
	private DocenteServiceImp docenteService;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
		model.addAttribute("titulo","Listado Docentes");
         model.addAttribute("docentes",docenteService.mostrarDocentes());
         return "/docente/docentes";
	}
	
	@GetMapping("/nuevo")
	public String getDocenteFormPage(Model model) {
		boolean edicion=false;
		model.addAttribute("titulo", "Nuevo Docente");
		model.addAttribute("docente",docenteDTO);
		model.addAttribute("edicion",edicion);
		return "/docente/docentesForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuadarDocentesPage(@Valid @ModelAttribute("docente") DocenteDTO docentedto, BindingResult result) {
         ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("/docente/docentesForm");
		}else{
			modelView = new ModelAndView("/docente/docentes");
			docenteService.guardarDocente(docentedto);
			modelView.addObject("docentes", docenteService.mostrarDocentes());	
		}
		
		return modelView;
	} 
	
	@GetMapping("/modificar/{id}")
	public String getModificarDocentesPage(Model model, @PathVariable(value="id") Long id) {
		DocenteDTO encontrado = docenteService.buscarDocente(id);
		boolean edicion=true;
		model.addAttribute("edicion",edicion);
		model.addAttribute("docente",encontrado);
		return "/docente/docentesForm";
	}
	
	@PostMapping("/modificar")
	public ModelAndView modificarDocente(@Valid @ModelAttribute("docente") DocenteDTO docentedto, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("/docente/docentesForm");
		}else {
		docenteService.modificarDocente(docentedto);
		modelView = new ModelAndView("redirect:/docente/listado");
		}
	     return modelView;
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCarrera(@PathVariable(value="id") Long id) {
		docenteService.EliminarDocente(id);
		return "redirect:/docente/listado";
	}
	
}
