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
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
@RequestMapping("/registro")
public class AlumnoInscripcion {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private IMateriaService materiaService;
    
    @Autowired
    private AlumnoMapper alumnoMapper;
    
    @Autowired
    private MateriaMapper materiaMapper;

    @GetMapping("/inscripcion")
    public String mostrarFormularioInscripcion(Model model) {
        List<AlumnoDTO> alumnos = alumnoService.mostrarALumnos();
        List<MateriaDTO> materias = materiaService.listaMateria();
        model.addAttribute("titulo", "Inscripcion Alumnos a Materia");
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("materias", materias);
        return "consultas/inscripcionAlumno";
    }
	
    @PostMapping("/inscripcion")
    public String inscribirAlumnoMateria(@RequestParam("alumnoId") Long alumnoId,
                                                @RequestParam("materiaId") Long materiaId) {
        
    	Alumno alumno = alumnoMapper.ConvertirAlumnoDTOAAlumno(alumnoService.buscarAlumno(alumnoId));
        Materia materia = materiaMapper.ConvertirMateriaDTOAMateria(materiaService.buscarMateria(materiaId));

        if (alumno != null && materia != null) {
            alumno.getMaterias().add(materia);
            materia.getAlumnos().add(alumno);

            alumnoService.modificarAlumno(alumnoMapper.ConvertirAlumnoAAlumnoDTO(alumno));
            materiaService.modificarMateria(materiaMapper.ConvertirMateriaAMateriaDTO(materia));

            return "redirect:/registro/inscripcion";
        } else {
            return "redirect:/registro/inscripcion";
        }
    }
	
}
