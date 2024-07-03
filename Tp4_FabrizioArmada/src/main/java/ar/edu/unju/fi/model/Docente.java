package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "docente")
@Entity()
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "D_id")
	private Long id;
	@Column(name = "D_legajo", nullable = false)
    private String legajo;
	@Column(name = "D_nombre", nullable = false)
    private String nombre;
	@Column(name = "D_apellido", nullable = false)
    private String apellido;
	@Column(name = "D_email", nullable = false)
    private String email;
	@Column(name = "D_telefono", nullable = false)
    private String telefono;
	@Column(name = "D_estado", nullable = false)
	private boolean estado;
  
	@OneToOne(mappedBy = "docente")
	private Materia materia;

    
}