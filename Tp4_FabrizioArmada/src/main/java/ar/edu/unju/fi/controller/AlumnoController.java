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
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.service.AlumnoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    /*
	@Autowired
	private Alumno alumno;
    */
	@Autowired
	private AlumnoDTO alumnoDTO;

   @Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/listado")
	public String getAlumnosPage(Model model) {
		model.addAttribute("titulo","Listado Alumnos");
		model.addAttribute("alumnos", alumnoService.mostrarALumnos());
		return "/alumno/alumnos";
	}
	
	@GetMapping("/nuevo")
	public String getAlumnosFormPage(Model model) {
		boolean edicion=false;
		model.addAttribute("titulo", "Nuevo Alumno");
		model.addAttribute("alumno", alumnoDTO);
		model.addAttribute("edicion", edicion);
		return "/alumno/alumnosForm";
	}
	@PostMapping("/guardar")
	public ModelAndView agregarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("/alumno/alumnosForm");
		}else {
		modelView = new ModelAndView("/alumno/alumnos");
		alumnoService.crearAlumno(alumnoDTO);
		modelView.addObject("alumnos", alumnoService.mostrarALumnos());
		}
		return modelView;
		}
	
	@GetMapping("/modificar/{id}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value="id") Long id) {
		AlumnoDTO encontrado = new AlumnoDTO();
		boolean edicion=true;
		encontrado=alumnoService.buscarAlumno(id);
		model.addAttribute("edicion",edicion);
		model.addAttribute("alumno",encontrado);
		return "/alumno/alumnosForm";
	}
	@PostMapping("/modificar")
	public ModelAndView modificarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnodto, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("/alumno/alumnosForm");
		}else {
		alumnoService.modificarAlumno(alumnodto);
		modelView = new ModelAndView("redirect:/alumno/listado");
	}
		return modelView;
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCarrera(@PathVariable(value="id") Long id) {
		alumnoService.eliminarAlumno(id);
		return "redirect:/alumno/listado";
	}
	
	
}
