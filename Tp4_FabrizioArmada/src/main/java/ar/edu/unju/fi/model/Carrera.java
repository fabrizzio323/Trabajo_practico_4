package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "CARRERAS")
@Entity(name = "carrera")
public class Carrera {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "C_codigo")
    private Long codigo;
	
	    @NotBlank(message="Ingrese el nombre")
	    @Size(min=3, max=20, message="Debe tener entre 3 y 20 caracteres")
	    @Pattern(regexp="[a-z A-Z]*", message="El nombre solo deben ser letras")
	    @Column(name = "C_nombre")
    private String nombre;
	    @Column(name = "C_cantidadAnios")
    private short cantidadAnios;
	    @Column(name = "C_estado")
    private boolean estado;
    
}