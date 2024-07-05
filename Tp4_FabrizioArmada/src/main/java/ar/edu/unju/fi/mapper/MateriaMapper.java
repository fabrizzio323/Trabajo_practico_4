package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.dto.MateriaDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MateriaMapper {

	@Mapping(source="codigo", target="codigo")
	@Mapping(source="nombre", target="nombre")
	@Mapping(source="curso", target="curso")
	@Mapping(source="cantidadHoras", target="cantidadHoras")
	@Mapping(source="modalidad", target="modalidad")
	@Mapping(source="docente", target="docente")
	@Mapping(source="carrera", target="carrera")
	@Mapping(source="estado", target="estado")
	MateriaDTO ConvertirMateriaAMateriaDTO(Materia materia);
	
	@InheritConfiguration
	Materia ConvertirMateriaDTOAMateria(MateriaDTO materiaDTO);
	
	List<MateriaDTO> ConvertirListaMateriaAListaMateriaDTO(List<Materia> materias);
	
	List<Materia> ConvertirListaMateriaDTOAListaMateria(List<MateriaDTO> materiasDTO);
}
