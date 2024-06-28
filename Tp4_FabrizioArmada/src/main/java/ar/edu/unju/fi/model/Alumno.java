package ar.edu.unju.fi.model;

import java.time.LocalDate;



import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
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
public class Alumno {
	@NotBlank(message="Ingrese el dni")
	@Size(min=8, message="el dni solo tiene 8 numeros")
	@Pattern(regexp="[0-9]*", message="Solo numeros por favor")
   private String dni;
	@NotBlank(message="Ingrese el nombre")
	@Size(min=3,max=20,message="nombre de entre 3 y 20 caracteres")
	@Pattern(regexp="[a-z A-Z]*",message="Solo letras")
   private String nombre;
	@NotBlank(message="Ingrese el apellido")
	@Size(min=3,max=20,message="apellido de entre 3 y 20 caracteres")
	@Pattern(regexp="[a-z A-Z]*",message="Solo letras")
   private String apellido;
	@NotBlank(message="Ingrese el email")
	@Email(message="El correo electronico tiene que ser valido example@gmail.com")
   private String email;
   private String telefono;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDate fechaNacimiento;
   private String domicilio;
   private String lu;
   
   
   
}