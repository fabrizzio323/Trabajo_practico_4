package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.service.ICarreraService;


@Controller
@RequestMapping("/consulta")
public class AlumnoCarrera {

    @Autowired
    private CarreraDTO carreraDTO;  

    @Autowired
    private ICarreraService iCarreraService;  

    @GetMapping("/alumnosPorCarrera")
    public String consultarAlumnosPorCarrera(Model model) {
        model.addAttribute("carreras", iCarreraService.listaCarreras());
        return "consultas/alumnosCarreras";  

    }
}