package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AlumnoDTO {
       private Long id;
       @NotBlank(message = "El DNI no puede ser nulo")
       @Pattern(regexp = "\\d{8}", message = "El DNI debe tener 8 dígitos")
       private String dni;
       @NotBlank(message = "El nombre no puede ser nulo")
       @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
       private String nombre;

       @NotBlank(message = "El apellido no puede ser nulo")
       @Size(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
       private String apellido;

       @NotBlank(message = "El correo electrónico no puede ser nulo")
       @Email(message = "Debe proporcionar un correo electrónico válido")
       @Size(max = 255, message = "El correo electrónico no puede tener más de 255 caracteres")
       private String email;

       @NotBlank(message = "El número de teléfono no puede ser nulo")
       @Pattern(regexp = "[0-9]*", message = "El telefono solo contiene numeros")
       @Size(min = 10, max = 15, message = "El número de teléfono debe tener entre 10 y 15 dígitos")
       private String telefono;

       @NotBlank(message = "La fecha de nacimiento no puede ser nula")
       @DateTimeFormat(pattern="yyyy/MM/dd")
       private String fechaNacimiento;

       @NotBlank(message = "El domicilio no puede ser nulo")
       @Size(min = 1, max = 255, message = "El domicilio debe tener entre 1 y 255 caracteres")
       private String domicilio;

       @NotBlank(message = "El LU no puede ser nulo")
       @Size(min = 1, max = 20, message = "El LU debe tener entre 1 y 20 caracteres")
       private String lu;

       private boolean estado;
       private List<Materia> materias;
}
