package ar.edu.unju.fi.model;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DOCENTES")
@Entity(name = "docente")
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "D_id")
	private Long id;
	@Column(name = "d_legajo")
    private String legajo;
	@Column(name = "d_nombre")
    private String nombre;
	@Column(name = "d_apellido")
    private String apellido;
	@Column(name = "d_email")
    private String email;
	@Column(name = "d_telefono")
    private String telefono;
  
    
    
}