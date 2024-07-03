package ar.edu.unju.fi.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "materias")

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "M_id")
	private Long id;
	
	@Column(name = "M_codigo", nullable = false)
	private int codigo;

	@Column(name = "M_nombre", nullable = false)
	private String nombre;

	@Column(name = "M_curso", nullable = false)
	private String curso;

	@Column(name = "M_cantidadHoras", nullable = false)
	private short cantidadHoras;

	@Column(name = "M_modalidad", nullable = false)
	private String modalidad;
	
	@Column(name = "M_estado", nullable = false)
	private boolean estado;
	
	@ManyToMany
	@JoinTable(name = "materias_y_alumnos",
	joinColumns = @JoinColumn(name = "M_id"),
	inverseJoinColumns = @JoinColumn(name = "A_id"))
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	

	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "D_id")
	private Docente docente;
	
	@ManyToOne
	@JoinColumn(name = "C_id")
	private Carrera carrera;
  
	
	public Materia(int codigo, String nombre, String curso, short cantidadHoras, String modalidad, boolean estado,
			List<Alumno> alumnos, Docente docente, Carrera carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.estado = estado;
		this.alumnos = alumnos;
		this.docente = docente;
		this.carrera = carrera;
	}
   
}