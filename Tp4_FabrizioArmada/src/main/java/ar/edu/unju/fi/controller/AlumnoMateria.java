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

	    @PostMapping("/listado")
	    public String filtrarAlumnos(@RequestParam("materia") Long materiaId, Model model) {
	        MateriaDTO materia = materiaService.buscarMateria(materiaId);
	        List<AlumnoDTO> alumnos = null;
	        if (materia != null) {
	            alumnos = alumnoMap.convertirListaAlumnoAListaAlumnoDTO(materia.getAlumnos());
	        }
	        List<MateriaDTO> materias = materiaService.listaMateria();
	        model.addAttribute("materias", materias);
	        model.addAttribute("alumnos", alumnos);
	        return "redirect:/filtro/alumnos";
	    }
	    
}
