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

    @GetMapping("/registro/inscribir")
    public String mostrarFormularioInscripcion(Model model) {
        List<AlumnoDTO> alumnos = alumnoService.mostrarALumnos();
        List<MateriaDTO> materias = materiaService.listaMateria();

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("materias", materias);

        return "inscribirAlumno";
    }

    @PostMapping("/registro/inscribir")
    public String inscribirAlumno(@RequestParam("alumno") Long alumnoId, 
                                  @RequestParam("materia") Long materiaId, 
                                  Model model) {
        AlumnoDTO alumnoDTO = alumnoService.buscarAlumno(alumnoId);
        MateriaDTO materiaDTO = materiaService.buscarMateria(materiaId);

        // Convertir DTO a entidad
        Alumno alumno = new Alumno();
        alumno.setId(alumnoDTO.getId());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellido(alumnoDTO.getApellido());
        // Agregar otras propiedades si es necesario

        Materia materia = new Materia();
        materia.setId(materiaDTO.getId());
        materia.setNombre(materiaDTO.getNombre());
        // Agregar otras propiedades si es necesario

        // Agregar la materia a la lista de materias del alumno
        alumno.getMaterias().add(materia);

        // Agregar el alumno a la lista de alumnos de la materia
        materia.getAlumnos().add(alumno);

        // Guardar los cambios
        alumnoService.modificarAlumno(alumnoDTO);
        materiaService.modificarMateria(materiaDTO);

        model.addAttribute("message", "Alumno inscrito exitosamente.");
        return "inscribirAlumno";
    }
}
