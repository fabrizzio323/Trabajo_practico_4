package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocenteMapper {

	@Mapping(source="legajo", target="legajo")
	@Mapping(source="nombre", target="nombre")
	@Mapping(source="apellido", target="apellido")
	@Mapping(source="email", target="email")
	@Mapping(source="telefono", target="telefono")
    DocenteDTO ConvertirDocenteADocenteDTO(Docente docente);
	
	@InheritConfiguration
	Docente ConvertirDocenteDTOAdocente(DocenteDTO DocenteDTO);
     
    List<DocenteDTO> ConvertirListaDocenteAListaDocenteDTO(List<Docente> docentes);
    
    List<Docente> ConvertirListaDocenteDTOAListaDocente(List<DocenteDTO> docentesDTO);
}
