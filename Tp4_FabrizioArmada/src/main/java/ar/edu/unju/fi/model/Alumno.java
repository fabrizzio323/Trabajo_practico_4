package ar.edu.unju.fi.model;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Component
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
   
   public Alumno() {
	// TODO Auto-generated constructor stub
}

public Alumno(String dni, String nombre, String apellido, String email, String telefono, LocalDate fechaNacimiento,
		String domicilio, String lu) {
	super();
	this.dni = dni;
	this.nombre = nombre;
	this.apellido = apellido;
	this.email = email;
	this.telefono = telefono;
	this.fechaNacimiento = fechaNacimiento;
	this.domicilio = domicilio;
	this.lu = lu;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
}

public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}

public String getDomicilio() {
	return domicilio;
}

public void setDomicilio(String domicilio) {
	this.domicilio = domicilio;
}

public String getLu() {
	return lu;
}

public void setLu(String lu) {
	this.lu = lu;
}
   
}