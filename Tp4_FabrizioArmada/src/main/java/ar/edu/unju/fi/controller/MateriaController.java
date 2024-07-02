package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListaCarrera;
import ar.edu.unju.fi.collections.ListaDocente;
import ar.edu.unju.fi.collections.ListaMateria;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IMateriaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/materia")
public class MateriaController {
    /*@Autowired
	private Materia materia;
    
    @Autowired
    private Docente docente;
    
    @Autowired
    private Carrera carrera;*/
    
    @Autowired
	private MateriaDTO materiaDTO;
    
    @Autowired
    private DocenteDTO docenteDTO;
    
    @Autowired
    private CarreraDTO carreraDTO;
    
    @Autowired
    private IMateriaService iMateriaService;
    
    @Autowired
    private ICarreraService iCarreraService;
    
	@GetMapping("/listado")
	public String getMateriasPage(Model model) {
		//model.addAttribute("materias", ListaMateria.listarMaterias());
		model.addAttribute("materias", iMateriaService.listaMateria());
		return "materias";
	}
	
	@GetMapping("/nuevo")
	public String getMateriasFormPage(Model model) {
		boolean edicion=false;
		//model.addAttribute("materia", materia);
		model.addAttribute("materia", materiaDTO);
		model.addAttribute("edicion", edicion);
		//model.addAttribute("docentes", ListaDocente.listarDocentes());
		//model.addAttribute("carreras", ListaCarrera.listarCarreras());
		model.addAttribute("carreras", iCarreraService.listaCarreras());
		return "materiasForm";
	}
	
	@PostMapping("/guardar")
	//public ModelAndView guardarMateria(@ModelAttribute("materia") Materia materia) {
	public ModelAndView guardarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO) {
	
		ModelAndView modelView = new ModelAndView("materias");
		//docente = ListaDocente.buscarDocentes(materia.getDocente().getLegajo());
        //carrera = ListaCarrera.buscarCarreras(materia.getCarrera().getCodigo());
        //materia.setCarrera(carrera);
        //materia.setDocente(docente);
		//ListaMateria.agregarMateria(materia);
		//modelView.addObject("materias",ListaMateria.listarMaterias());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo") Long codigo) {
		/*Materia encontrado = new Materia();
		encontrado = ListaMateria.buscarMaterias(codigo);
		boolean edicion=true;
		model.addAttribute("materia",encontrado);
		model.addAttribute("docentes", ListaDocente.listarDocentes());
		model.addAttribute("carreras", ListaCarrera.listarCarreras());
		model.addAttribute("edicion", edicion);*/
		return "materiasForm";
	}
	
	@PostMapping("modificar")
	public String modificarMateria(@ModelAttribute("materia") Materia materia) {
		/*docente = ListaDocente.buscarDocentes(materia.getDocente().getLegajo());
        carrera = ListaCarrera.buscarCarreras(materia.getCarrera().getCodigo());
        materia.setCarrera(carrera);
        materia.setDocente(docente);*/
       // ListaMateria.modificarMateria(materia);
		return "redirect:/materia/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo") Long codigo) {
		//ListaMateria.eliminarMaterias(codigo);
		iMateriaService.eliminarMateria(codigo);
		return "redirect:/materia/listado";
	}
	
}
