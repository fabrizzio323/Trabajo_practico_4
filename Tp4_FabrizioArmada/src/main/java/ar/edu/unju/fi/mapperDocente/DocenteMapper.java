package ar.edu.unju.fi.mapperDocente;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.docenteDTO.DocenteDTO;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Docente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocenteMapper {

	@Mapping(source="legajo", target="legajo")
	@Mapping(source="nombre", target="nombre")
	@Mapping(source="apellido", target="apellido")
	@Mapping(source="email", target="email")
	@Mapping(source="telefono", target="telefono")
    DocenteDTO toDocenteDto(Docente docente);
	
	@InheritConfiguration
	Docente ToDocente(DocenteDTO DocenteDTO);
     
    List<DocenteDTO> ToDocenteDTOList(List<Docente> docentes);
    
    List<Docente> ToDocenteList(List<DocenteDTO> docentesDTO);
}
