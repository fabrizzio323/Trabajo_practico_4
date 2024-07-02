package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "MATERIAS")
@Entity(name = "materia")
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "M_id")
		private Long id;
	@Column(name = "M_codigo")
		private int codigo;
	
	@Column(name = "M_nombre")
	   	private String nombre;
	
	@Column(name = "M_curso")
	   	private String curso;
	
	@Column(name = "M_cantidadHoras")
	   	private short cantidadHoras;
	
	@Column(name = "M_modalidad")
	   	private String modalidad;
	
	@Column(name = "M_docente")
   @Autowired
   		private Docente docente;
	
	@Column(name = "M_carrera")
   @Autowired
   		private Carrera carrera;
   
}