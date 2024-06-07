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

import ar.edu.unju.fi.collections.ListaCarrera;
import ar.edu.unju.fi.collections.ListaDocente;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
    @Autowired
    private Docente docente;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
         model.addAttribute("docentes",ListaDocente.listarDocentes());
         return "docentes";
	}
	
	@GetMapping("/nuevo")
	public String getDocenteFormPage(Model model) {
		boolean edicion=false;
		model.addAttribute("docente",docente);
		model.addAttribute("edicion",edicion);
		return "docentesForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuadarCarrerasPage(@ModelAttribute("docente") Docente docente) {
		ModelAndView modelView = new ModelAndView("docentes");
		ListaDocente.agregarDocente(docente);
		modelView.addObject("docentes", ListaDocente.listarDocentes());
		return modelView;
	} 
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="legajo") String legajo) {
		Docente encontrado = new Docente();
		boolean edicion=true;
		encontrado=ListaDocente.buscarDocentes(legajo);
		model.addAttribute("edicion",edicion);
		model.addAttribute("docente",encontrado);
		return "docentesForm";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("docente") Docente docente) {
		ListaDocente.modificarDocente(docente);
		return "redirect:/docente/listado";
	}
	
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarCarrera(@PathVariable(value="legajo") String legajo) {
		ListaDocente.eliminarDocente(legajo);
		return "redirect:/docente/listado";
	}
	
}
