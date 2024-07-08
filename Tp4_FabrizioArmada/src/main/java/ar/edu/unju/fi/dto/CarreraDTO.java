package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CarreraDTO {

	private Long id;
	@NotNull(message="El codigo no puede estar vacio")
	private int codigo;
	@NotBlank(message="El nombre no puede estar vacio")
	@Size(min=5,max=20,message="el nombre debe tener entre 5 y 20 caracteres")
	private String nombre;
	@NotNull(message="La duracion no puede estar vacia")
	@Min(value=3, message="La duracion minima es de 3 años")
    @Max(value=5, message="La duracion maxima es de 6 años")
	private short cantidadAnios;
	private String estado;
	//ver de cambiar boolean por String
	
	private List<Materia> materias;
}
