package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

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
	@Override
	public void guardarDocente(DocenteDTO docentedto) {
		Docente docente = docenteMap.ConvertirDocenteDTOAdocente(docentedto);
		docente.setEstado(true);
		docenteRepository.save(docente);
	}

	@Override
	public List<DocenteDTO> mostrarDocentes() {
		List<DocenteDTO> docentesDto = new ArrayList<DocenteDTO>();
		docentesDto = (List<DocenteDTO>) docenteMap.ConvertirListaDocenteAListaDocenteDTO(docenteRepository.findAll());
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
	}

	@Override
	public void modificarDocente(DocenteDTO docentedto) {
		Docente docente = docenteMap.ConvertirDocenteDTOAdocente(docentedto);
		docente.setEstado(true);
		docenteRepository.save(docente);
		
	}

	@Override
	public DocenteDTO buscarDocente(Long id) {
		return docenteMap.ConvertirDocenteADocenteDTO(docenteRepository.findById(id).get());
	}

}
