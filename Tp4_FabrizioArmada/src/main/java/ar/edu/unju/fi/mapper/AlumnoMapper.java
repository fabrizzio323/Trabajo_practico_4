package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlumnoMapper {
    
	@Mapping(source="dni", target="dni")
	@Mapping(source="nombre", target="nombre")
	@Mapping(source="apellido", target="apellido")
	@Mapping(source="email", target="email")
	@Mapping(source="telefono", target="telefono")
	@Mapping(source="fechaNacimiento", target="fechaNacimiento", dateFormat="yyyy-MM-dd")
	@Mapping(source="domicilio", target="domicilio")
	@Mapping(source="lu", target="lu")
	@Mapping(source="estado", target="estado")
	AlumnoDTO ConvertirAlumnoAAlumnoDTO(Alumno alumno);
	
	@InheritConfiguration
	Alumno ConvertirAlumnoDTOAAlumno(AlumnoDTO alumnoDTO);
     
    List<AlumnoDTO> convertirListaAlumnoAListaAlumnoDTO(List<Alumno> alumnos);
    
    List<Alumno> CovertirListaAlumnoDTOAlistaAlumno(List<AlumnoDTO> alumnosDTO);
}
