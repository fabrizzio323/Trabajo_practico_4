package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.DocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {
 
	@Autowired
	private DocenteDTO docenteDTO;
	@Autowired	
	private DocenteService docenteService;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
         model.addAttribute("docentes",docenteService.mostrarDocentes());
         return "/docente/docentes";
	}
	
	@GetMapping("/nuevo")
	public String getDocenteFormPage(Model model) {
		boolean edicion=false;
		model.addAttribute("docente",docenteDTO);
		model.addAttribute("edicion",edicion);
		return "/docente/docentesForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuadarDocentesPage(@ModelAttribute("docente") DocenteDTO docentedto) {
		ModelAndView modelView = new ModelAndView("/docente/docentes");
		docenteService.guardarDocente(docentedto);
		modelView.addObject("docentes", docenteService.mostrarDocentes());
		return modelView;
	} 
	
	@GetMapping("/modificar/{id}")
	public String getModificarDocentesPage(Model model, @PathVariable(value="id") Long id) {
		DocenteDTO encontrado = new DocenteDTO();
		boolean edicion=true;
		encontrado=docenteService.buscarDocente(id);
		model.addAttribute("edicion",edicion);
		model.addAttribute("docente",encontrado);
		return "/docente/docentesForm";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") DocenteDTO docentedto) {
		docenteService.modificarDocente(docentedto);
		return "redirect:/docente/listado";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCarrera(@PathVariable(value="id") Long id) {
		DocenteDTO docentedto = docenteService.buscarDocente(id);
		docenteService.EliminarDocente(docentedto);
		return "redirect:/docente/listado";
	}
	
}
