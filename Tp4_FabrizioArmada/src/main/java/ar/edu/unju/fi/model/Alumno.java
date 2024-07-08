package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alumnos")
@Entity()
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "A_id")
	private Long id;
	@Column(name = "A_dni", nullable = false)
	private String dni;
	
	@Column(name = "A_nombre", nullable = false)
   private String nombre;
	
	@Column(name = "A_apellido", nullable = false)
   private String apellido;
	
	@Column(name = "A_email", nullable = false)
   private String email;
	@Column(name = "A_telefono", nullable = false)
   private String telefono;
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   @Column(name = "A_fechaNacimiento", nullable = false)
   private LocalDate fechaNacimiento;
   @Column(name = "A_domicilio", nullable = false)
   private String domicilio;
   @Column(name = "A_lu", nullable = false)
   private String lu;
   @Column(name = "A_estado", nullable = false)
   private boolean estado;
   
   @ManyToMany(mappedBy = "alumnos")
   private List<Materia> materias = new ArrayList<Materia>();
   
   
}