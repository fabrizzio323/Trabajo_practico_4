package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carreras")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_id")
	private Long id;
	@Column(name = "C_codigo", nullable = false)
	private int codigo;
	@Column(name = "C_nombre", nullable = false)
	private String nombre;
	@Column(name = "C_cantidadAnios", nullable = false)
	private short cantidadAnios;
	@Column(name = "C_estado", nullable = false)
	private boolean estado;

	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	private List<Materia> materias;

	public Carrera(int codigo, String nombre, short cantidadAnios, boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
	}

}