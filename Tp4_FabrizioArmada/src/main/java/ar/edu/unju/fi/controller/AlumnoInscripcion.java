package ar.edu.unju.fi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

   /* @GetMapping("/inscribir")
    public String mostrarFormularioInscripcion(Model model) {
        List<AlumnoDTO> alumnos = alumnoService.mostrarALumnos();
        List<MateriaDTO> materias = materiaService.listaMateria();
        model.addAttribute("titulo", "Inscripcion Alumnos a Materia");
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("materias", materias);
        return "consultas/inscripcionAlumno";
    }

    @PostMapping("/listado")
    public String inscribirAlumno(@RequestParam("alumno") Long alumnoId, 
                                  @RequestParam("materia") Long materiaId, 
                                  Model model) {
    	 AlumnoDTO alumnoDTO = alumnoService.buscarAlumno(alumnoId);
         MateriaDTO materiaDTO = materiaService.buscarMateria(materiaId);

         // Convertir DTO a entidad si es necesario (dependiendo de tu implementación)
         Alumno alumno = alumnoMapper.ConvertirAlumnoDTOAAlumno(alumnoDTO);
         Materia materia = materiaMapper.ConvertirMateriaDTOAMateria(materiaDTO);
        		 
         // Añadir la materia al alumno y el alumno a la materia
         alumno.getMaterias().add(materia);
         materia.getAlumnos().add(alumno);

         // Guardar los cambios en el servicio correspondiente
         alumnoService.modificarAlumno(alumnoMapper.ConvertirAlumnoAAlumnoDTO(alumno));
         materiaService.modificarMateria(materiaMapper.ConvertirMateriaAMateriaDTO(materia));

         // Redirigir a la página de éxito o mostrar mensaje de éxito
         model.addAttribute("message", "Alumno inscrito exitosamente.");
        return "redirect:/registro/inscribir";
    }*/
    

    

    @GetMapping("/inscripcion")
    public ModelAndView mostrarFormularioInscripcion(Model model) {
       /* List<AlumnoDTO> alumnos = alumnoService.mostrarALumnos();
        List<MateriaDTO> materias = materiaService.listaMateria();*/
        ModelAndView modelAndView = new ModelAndView("inscripcionAlumno");
        model.addAttribute("titulo", "Inscripcion Alumnos a Materia");
        model.addAttribute("alumnos", alumnoService.mostrarALumnos());
        model.addAttribute("materias", materiaService.listaMateria());
        return modelAndView;
    }
	
    @PostMapping("/inscripcion")
    public ModelAndView inscribirAlumnoMateria(@RequestParam("alumnoId") Long alumnoId,
                                                @RequestParam("materiaId") Long materiaId) {
        
    	Alumno alumno = alumnoMapper.ConvertirAlumnoDTOAAlumno(alumnoService.buscarAlumno(alumnoId));
        Materia materia = materiaMapper.ConvertirMateriaDTOAMateria(materiaService.buscarMateria(materiaId));

        if (alumno != null && materia != null) {
            // Añadir la materia al alumno y el alumno a la materia
            alumno.getMaterias().add(materia);
            materia.getAlumnos().add(alumno);

            // Guardar los cambios en los servicios correspondientes (si es necesario)
            
            alumnoService.modificarAlumno(alumnoMapper.ConvertirAlumnoAAlumnoDTO(alumno));
            materiaService.modificarMateria(materiaMapper.ConvertirMateriaAMateriaDTO(materia));

            // Redirigir a la página de éxito o mostrar mensaje de éxito
            return new ModelAndView("redirect:/registro/inscripcion?success");
        } else {
            // Manejar el caso donde no se encuentre el alumno o la materia
            return new ModelAndView("redirect:/registro/inscripcion?error");
        }
    }
	 /*
	@GetMapping("/alumno/{aluId}/materia/{matId}")
	public ModelAndView getRegistrarAlumno(@PathVariable(value="aluId")Long aluId,@PathVariable(value="matId")Long matId, Model model) {
		
		Alumno alumnoEncontrado = alumnoMapper.ConvertirAlumnoDTOAAlumno(alumnoService.buscarAlumno(aluId));
		Materia materia= materiaMapper.ConvertirMateriaDTOAMateria(materiaService.buscarMateria(matId));
		
		materia.getAlumnos().add(alumnoEncontrado);
		materiaService.crearMateria(materiaMapper.ConvertirMateriaAMateriaDTO(materia));
		
		model.addAttribute("alumnos", alumnoService.mostrarALumnos());
        model.addAttribute("titulo", "Alumnos");
		
		ModelAndView modelView = new ModelAndView("alumnos");
		
		return modelView;
		
	}*/
}
