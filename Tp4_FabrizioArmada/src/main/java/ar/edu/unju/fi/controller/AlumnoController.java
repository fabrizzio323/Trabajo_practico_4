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

import ar.edu.unju.fi.collections.ListaAlumno;
import ar.edu.unju.fi.collections.ListaCarrera;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
	private Alumno alumno;
    
	@GetMapping("/listado")
	public String getAlumnosPage(Model model) {
		model.addAttribute("alumnos", ListaAlumno.listarAlumnos());
		return "alumnos";
	}
	
	@GetMapping("/nuevo")
	public String getAlumnosFormPage(Model model) {
		boolean edicion=false;
		model.addAttribute("alumno", alumno);
		model.addAttribute("edicion", edicion);
		return "alumnosForm";
	}
	@PostMapping("/guardar")
	public ModelAndView agregarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		ModelAndView modelView = new ModelAndView("alumnos");		
		ListaAlumno.agregarAlumno(alumno);
		modelView.addObject("alumnos", ListaAlumno.listarAlumnos());
		return modelView;
	}
	
	@GetMapping("/modificar/{lu}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="lu") String lu) {
		Alumno encontrado = new Alumno();
		boolean edicion=true;
		encontrado=ListaAlumno.buscarAlumnos(lu);
		model.addAttribute("edicion",edicion);
		model.addAttribute("alumno",encontrado);
		return "alumnosForm";
	}
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("alumno") Alumno alumno) {
		ListaAlumno.modificarAlumno(alumno);
		return "redirect:/alumno/listado";
	}
	
	@GetMapping("/eliminar/{lu}")
	public String eliminarCarrera(@PathVariable(value="lu") String lu) {
		ListaAlumno.borrarAlumnos(lu);
		return "redirect:/alumno/listado";
	}
	
}
