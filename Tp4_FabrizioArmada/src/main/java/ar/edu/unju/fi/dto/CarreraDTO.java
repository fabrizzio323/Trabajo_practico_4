package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CarreraDTO {

	private Long id;
	private int codigo;
	private String nombre;
	private short cantidadAnios;
	private String estado;
	//ver de cambiar boolean por String
	
	private List<Materia> materias;
}
