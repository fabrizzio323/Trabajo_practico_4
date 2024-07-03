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
@Table(name = "alumnos")
@Entity()
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "A_id")
	private Long id;
	@NotBlank(message="Ingrese el dni")
	@Size(min=8, message="el dni solo tiene 8 numeros")
	@Pattern(regexp="[0-9]*", message="Solo numeros por favor")
	@Column(name = "A_dni", nullable = false)
	private String dni;
	@NotBlank(message="Ingrese el nombre")
	@Size(min=3,max=20,message="nombre de entre 3 y 20 caracteres")
	@Pattern(regexp="[a-z A-Z]*",message="Solo letras")
	@Column(name = "A_nombre", nullable = false)
   private String nombre;
	@NotBlank(message="Ingrese el apellido")
	@Size(min=3,max=20,message="apellido de entre 3 y 20 caracteres")
	@Pattern(regexp="[a-z A-Z]*",message="Solo letras")
	@Column(name = "A_apellido", nullable = false)
   private String apellido;
	@NotBlank(message="Ingrese el email")
	@Email(message="El correo electronico tiene que ser valido example@gmail.com")
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