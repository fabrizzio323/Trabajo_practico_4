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
	public String consultarAlumnoCarrera(@RequestParam("carrera") Long carreraId, Model model) {
	    CarreraDTO carrera = carreraService.buscarCarrera(carreraId);
	    List<MateriaDTO> materias = null;
	    List<AlumnoDTO> alumnos = null;
	    
	    if (carrera != null) {
	        materias = materiaMap.ConvertirListaMateriaAListaMateriaDTO(carrera.getMaterias());
	        alumnos = new ArrayList<>();
	        for (MateriaDTO materia : materias) {
	            alumnos.addAll(alumnoMap.convertirListaAlumnoAListaAlumnoDTO(materia.getAlumnos()));
	        }
	    }
	    List<CarreraDTO> carreras = carreraService.listaCarreras();
	    model.addAttribute("carreras", carreras);
	    model.addAttribute("materias", materias);
	    model.addAttribute("alumnos", alumnos);
	    return "consultas/alumnosCarreras";
	}
}