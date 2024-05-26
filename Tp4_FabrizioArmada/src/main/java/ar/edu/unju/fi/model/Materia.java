package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
@Component
public class Materia {
   private int codigo;
   private String nombre;
   private String curso;
   private short cantidadHoras;
   private String modalidad;
   private Docente docente;
   private String carrera;
   
   public Materia() {
	// TODO Auto-generated constructor stub
}

public Materia(int codigo, String nombre, String curso, short cantidadHoras, String modalidad, Docente docente,
		String carrera) {
	this.codigo = codigo;
	this.nombre = nombre;
	this.curso = curso;
	this.cantidadHoras = cantidadHoras;
	this.modalidad = modalidad;
	this.docente = docente;
	this.carrera = carrera;
}

public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCurso() {
	return curso;
}

public void setCurso(String curso) {
	this.curso = curso;
}

public short getCantidadHoras() {
	return cantidadHoras;
}

public void setCantidadHoras(short cantidadHoras) {
	this.cantidadHoras = cantidadHoras;
}

public String getModalidad() {
	return modalidad;
}

public void setModalidad(String modalidad) {
	this.modalidad = modalidad;
}

public Docente getDocente() {
	return docente;
}

public void setDocente(Docente docente) {
	this.docente = docente;
}

public String getCarrera() {
	return carrera;
}

public void setCarrera(String carrera) {
	this.carrera = carrera;
}
 
   
}