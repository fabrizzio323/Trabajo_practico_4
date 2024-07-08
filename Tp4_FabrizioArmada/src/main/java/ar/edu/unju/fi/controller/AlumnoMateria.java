package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IMateriaService;
import ar.edu.unju.fi.service.imp.AlumnoServiceImp;

@Controller
@RequestMapping("/filtro")
public class AlumnoMateria {

	 @Autowired
	    private IMateriaService iMateriaService; 
	 
	    @Autowired
	    private AlumnoServiceImp iAlumnoService; 
	    
	    @GetMapping("/formulario")
	    public String mostrarFormulario(Model model) {
	        model.addAttribute("materias", iMateriaService.listaMateria()); 
	        return "consultas/alumnosMaterias"; 
	    }

	    
}
