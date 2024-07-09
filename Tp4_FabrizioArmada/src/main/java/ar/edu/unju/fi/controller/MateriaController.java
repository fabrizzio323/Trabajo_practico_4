package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.DocenteService;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IMateriaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	private MateriaDTO materiaDTO;

	@Autowired
	private IMateriaService iMateriaService;

	@Autowired
	private ICarreraService iCarreraService;

	@Autowired
	private DocenteService iDocenteService;

	@GetMapping("/listado")
	public String getMateriasPage(Model model) {
		model.addAttribute("titulo", "Listado Materias");
		model.addAttribute("materias", iMateriaService.listaMateria());
		return "/materia/materias";
	}

	@GetMapping("/nuevo")
	public String getMateriasFormPage(Model model) {
		boolean edicion = false;
		model.addAttribute("titulo", "Nueva Materia");
		model.addAttribute("materia", materiaDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docentes", iDocenteService.mostrarDocentesNoAsignados());
		model.addAttribute("carreras", iCarreraService.listaCarreras());
		return "/materia/materiasForm";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@Valid @ModelAttribute("materia") MateriaDTO materiaDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        ModelAndView modelView = new ModelAndView("/materia/materiasForm");
	        modelView.addObject("docentes", iDocenteService.mostrarDocentesNoAsignados());
	        modelView.addObject("carreras", iCarreraService.listaCarreras());
	        return modelView;
	    }
	    iMateriaService.crearMateria(materiaDTO);
	    ModelAndView modelView = new ModelAndView("redirect:/materia/listado");
	    modelView.addObject("materias", iMateriaService.listaMateria());
	    return modelView;
	}


	@GetMapping("/modificar/{id}")
	public String getModificarMateriaPage(Model model, @PathVariable(value = "id") Long id) {
		MateriaDTO encontrado = iMateriaService.buscarMateria(id);
		boolean edicion = true;
		model.addAttribute("materia", encontrado);
		model.addAttribute("docentes", iDocenteService.mostrarDocentesNoAsignados());
		model.addAttribute("carreras", iCarreraService.listaCarreras());
		model.addAttribute("edicion", edicion);
		return "/materia/materiasForm";
	}

	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO) {
		iMateriaService.modificarMateria(materiaDTO);
		return "redirect:/materia/listado";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarMateria(@PathVariable(value = "id") Long id) {
		MateriaDTO materiaEncontradaDTO = iMateriaService.buscarMateria(id);
		iMateriaService.eliminarMateria(materiaEncontradaDTO);
		return "redirect:/materia/listado";
	}

}
