package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaDTO {

	private Long id;
	@NotNull(message="El codigo no puede estar vacio")
	private int codigo;
	@NotBlank(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String nombre;
	@NotBlank(message = "El curso no puede ser nulo")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String curso;
	@NotNull(message = "La cantidad de horas no puede ser nula")
    @Min(value = 0, message = "La cantidad mínima de horas es 0")
    @Max(value = 24, message = "La cantidad máxima de horas es 24")
	private short cantidadHoras;
	@NotBlank(message="La modalidad no puede ser nula")
	private String modalidad;
	@NotNull(message="El campo docente no puede estar nulos")
	private DocenteDTO docente;
	@NotNull(message="El campo carrera no puede estar nulos")
	private CarreraDTO carrera;
	 private String estado;
	 private List<Alumno> alumnos;

}
