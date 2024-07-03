package ar.edu.unju.fi.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DocenteServiceImp implements DocenteService{
	@Autowired
	private DocenteRepository docenteRepository;
	@Autowired
	private DocenteMapper docenteMap;
	
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
