package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaDTO {

	 private int codigo;
	 private String nombre;
	 private String curso;
	 private short cantidadHoras;
	 private String modalidad;
	 private DocenteDTO docente;
	 private CarreraDTO carrera;
	
}
