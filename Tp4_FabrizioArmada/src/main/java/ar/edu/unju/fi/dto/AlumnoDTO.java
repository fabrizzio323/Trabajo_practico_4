package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AlumnoDTO {
       private Long id;
       private String dni;
       private String nombre;
       private String apellido;
       private String email;
       private String telefono;
       private String fechaNacimiento;
       private String domicilio;
       private String lu;
       private boolean estado;
       private List<Materia> materias;
}
