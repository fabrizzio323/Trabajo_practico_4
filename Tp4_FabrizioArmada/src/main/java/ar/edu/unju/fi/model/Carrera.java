package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Carrera {
	
    private int codigo;
    @NotBlank(message="Ingrese el nombre")
    @Size(min=3, max=20, message="Debe tener entre 3 y 20 caracteres")
    @Pattern(regexp="[a-z A-Z]*", message="El nombre solo deben ser letras")
    private String nombre;
    private short cantidadAnios;
    private boolean estado;
    
}