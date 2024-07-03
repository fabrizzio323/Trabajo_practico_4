package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaDTO {

	private Long id;
	private int codigo;
	private String nombre;
	private String curso;
	private short cantidadHoras;
	private String modalidad;
	private DocenteDTO docente;
	private CarreraDTO carrera;
	
	 private String estado;
	 private List<Alumno> alumnos;

}
