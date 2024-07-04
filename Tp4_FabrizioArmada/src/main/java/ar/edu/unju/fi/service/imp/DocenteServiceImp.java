package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.DocenteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DocenteServiceImp implements DocenteService{
	@Autowired
	private DocenteRepository docenteRepository;
	@Autowired
	private DocenteMapper docenteMap;
	@Autowired
	private MateriaRepository materiaRepository;
	
	private static final Log LOGGER = LogFactory.getLog(DocenteServiceImp.class);
	
	@Override
	public void guardarDocente(DocenteDTO docentedto) {
		Docente docente = docenteMap.ConvertirDocenteDTOAdocente(docentedto);
		docente.setEstado(true);
		docenteRepository.save(docente);
		LOGGER.info("Docente guardado con exito");
	}

	@Override
	public List<DocenteDTO> mostrarDocentes() {
		List<DocenteDTO> docentesDto = new ArrayList<DocenteDTO>();
		docentesDto = (List<DocenteDTO>) docenteMap.ConvertirListaDocenteAListaDocenteDTO(docenteRepository.findAll());
		LOGGER.info("Lista de docentes");
		return docentesDto;
	}
	@Override
	public List<DocenteDTO> mostrarDocentesNoAsignados() {
	    List<Docente> docentes = docenteRepository.findAll();

	
	    List<Long> idsDocentesAsignados = new ArrayList<>();
	    List<Materia> materiasActivas = materiaRepository.findByEstado(true);
	    for (Materia materia : materiasActivas) {
	        idsDocentesAsignados.add(materia.getDocente().getId());
	    }
	    List<Docente> docentesNoAsignados = new ArrayList<>();
	    for (Docente docente : docentes) {
	        if (!idsDocentesAsignados.contains(docente.getId()) && docente.isEstado()) {
	            docentesNoAsignados.add(docente);
	        }
	    }

	    return docenteMap.ConvertirListaDocenteAListaDocenteDTO(docentesNoAsignados);
	}
	

	@Override
	public void EliminarDocente(DocenteDTO docentedto) {
		Docente docente = docenteMap.ConvertirDocenteDTOAdocente(docentedto);
		docente.setEstado(false);
		docenteRepository.save(docente);
		LOGGER.info("Docente eliminado con exito");
	}

	@Override
	public void modificarDocente(DocenteDTO docentedto) {
		Docente docente = docenteMap.ConvertirDocenteDTOAdocente(docentedto);
		docente.setEstado(true);
		docenteRepository.save(docente);
		LOGGER.info("Modificacion realizada con exito");
	}

	@Override
	public DocenteDTO buscarDocente(Long id) {
		Optional<Docente> OpDocente = docenteRepository.findById(id);
		LOGGER.info("Busqueda en proceso");
		if(OpDocente.isPresent()) {
			Docente docente = OpDocente.get();
			DocenteDTO docentedto = docenteMap.ConvertirDocenteADocenteDTO(docente);
			LOGGER.info("Busqueda realizada con exito");
			return docentedto;
		}else {
			return null;
		}
		
	}

}
