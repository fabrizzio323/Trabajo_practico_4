package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.service.IMateriaService;


@Controller
@RequestMapping("/filtro")
public class AlumnoMateria {
	
	 @Autowired
	 	private IMateriaService materiaService;
	 
	 @Autowired
	 	private AlumnoMapper alumnoMap;
	 

	    @GetMapping("/alumnos")
	    public String mostrarFiltro(Model model) {
	        List<MateriaDTO> materias = materiaService.listaMateria();
	        model.addAttribute("titulo", "Filtro de Alumnos por Materia");
	        model.addAttribute("materias", materias);
	        return "consultas/alumnosMaterias";
	    }

	    @PostMapping("/alumnos")
	    public String filtrarAlumnos(@RequestParam(value = "materia", required = false) Long materiaId, Model model) {
	        List<MateriaDTO> materias = materiaService.listaMateria();
	        model.addAttribute("materias", materias);

	        if (materiaId == null) {
	            model.addAttribute("error", "Por favor seleccione una materia.");
	            return "consultas/alumnosMaterias";
	        }

	        MateriaDTO materia = materiaService.buscarMateria(materiaId);
	        if (materia == null) {
	            model.addAttribute("error", "Materia no encontrada.");
	            return "consultas/alumnosMaterias";
	        }

	        List<AlumnoDTO> alumnos = alumnoMap.convertirListaAlumnoAListaAlumnoDTO(materia.getAlumnos());
	        if (alumnos.isEmpty()) {
	            model.addAttribute("error", "No hay alumnos inscriptos en la materia.");
	            return "consultas/alumnosMaterias";
	        }

	        model.addAttribute("alumnos", alumnos);
	        return "consultas/alumnosMaterias";
	    }

}
