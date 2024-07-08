package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
@RequestMapping("/registro")
public class AlumnoInscripcion {

    @Autowired
    private IMateriaService iMateriaService;

    @Autowired
    private AlumnoService iAlumnoService;

    @Autowired
    private ICarreraService iCarreraService; // Asumiendo que tienes un servicio de carrera

    @Autowired
    private AlumnoMapper alumnoMap;

    @Autowired
    private MateriaMapper materiaMap;

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alumnos", iAlumnoService.mostrarALumnos());
        model.addAttribute("carreras", iCarreraService.listaCarreras());
        model.addAttribute("materias", iMateriaService.listaMateria());
        return "consultas/inscripcionAlumno"; 
    }

    @PostMapping("/inscribir")
    public String inscribirAlumnoEnMateria(@RequestParam("alumno") Long alumnoId,
                                           @RequestParam("carrera") Long carreraId,
                                           @RequestParam("materia") Long materiaId,
                                           Model model) {
        // Buscar y mapear alumno
        Alumno alumno = alumnoMap.ConvertirAlumnoDTOAAlumno(iAlumnoService.buscarAlumno(alumnoId));
        if (alumno == null) {
            model.addAttribute("error", "Alumno no encontrado");
            return "error"; 
        }

        // Buscar y mapear materia
        Materia materia = materiaMap.ConvertirMateriaDTOAMateria(iMateriaService.buscarMateria(materiaId));
        if (materia == null) {
            model.addAttribute("error", "Materia no encontrada");
            return "error"; 
        }

        // Inscribir alumno en la materia
        materia.getAlumnos().add(alumno);
        iMateriaService.crearMateria(materiaMap.ConvertirMateriaAMateriaDTO(materia));

        // Actualizar modelo con datos
        model.addAttribute("alumnos", iAlumnoService.mostrarALumnos());
        model.addAttribute("titulo", "AlumnoInscripcion");

        return "redirect:/registro/formulario";
    }
}
