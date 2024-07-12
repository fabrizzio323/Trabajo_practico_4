package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.service.ICarreraService;

@Controller
@RequestMapping("/consulta")
public class AlumnoCarrera {
	@Autowired
	private ICarreraService carreraService;

	@Autowired
	private MateriaMapper materiaMap;

	@Autowired
	private AlumnoMapper alumnoMap;

	@GetMapping("/alumnosPorCarrera")
	public String consultarAlumnosPorCarrera(Model model) {
		model.addAttribute("carreras", carreraService.listaCarreras());
		return "consultas/alumnosCarreras";

	}

	@PostMapping("/alumnosPorCarrera")
	public String consultarAlumnoCarrera(@RequestParam(value = "carrera", required = false) Long carreraId, Model model) {
	    List<CarreraDTO> carreras = carreraService.listaCarreras();
	    model.addAttribute("carreras", carreras);

	    if (carreraId == null) {
	        model.addAttribute("error", "Por favor seleccione una carrera.");
	        return "consultas/alumnosCarreras";
	    }

	    CarreraDTO carrera = carreraService.buscarCarrera(carreraId);
	    if (carrera == null) {
	        model.addAttribute("error", "Carrera no encontrada.");
	        return "consultas/alumnosCarreras";
	    }

	    List<MateriaDTO> materias = materiaMap.ConvertirListaMateriaAListaMateriaDTO(carrera.getMaterias());
	    List<AlumnoDTO> alumnos = new ArrayList<>();
	    for (MateriaDTO materia : materias) {
	        alumnos.addAll(alumnoMap.convertirListaAlumnoAListaAlumnoDTO(materia.getAlumnos()));
	    }
	    
	    if (alumnos.isEmpty()) {
	        model.addAttribute("error", "No hay alumnos inscriptos a la carrera.");
	        return "consultas/alumnosCarreras";
	    }

	    model.addAttribute("materias", materias);
	    model.addAttribute("alumnos", alumnos);

	    return "consultas/alumnosCarreras";
	}
}