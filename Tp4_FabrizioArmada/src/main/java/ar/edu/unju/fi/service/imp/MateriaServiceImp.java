package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;

@Service("materiaServiceMysql")
public class MateriaServiceImp implements IMateriaService {

	@Autowired
	private MateriaRepository materiaRepository; 
	
	@Autowired
	private MateriaMapper materiaMapper; 
	
	@Override
	public void crearMateria(MateriaDTO materiaDTO) {
		materiaRepository.save(materiaMapper.ConvertirMateriaDTOAMateria(materiaDTO));
	}

	@Override
	public List<MateriaDTO> listaMateria() {
		List<MateriaDTO> materiasDTO = materiaMapper.ConvertirListaMateriaAListaMateriaDTO(materiaRepository.findAll());
		return materiasDTO;
	}

	@Override
	public void eliminarMateria(Long id) {
		materiaRepository.deleteById(id);
	}

	@Override
	public void modificarMateria(MateriaDTO materiaDTO) {
		materiaRepository.save(materiaMapper.ConvertirMateriaDTOAMateria(materiaDTO));
	}

	@Override
	public MateriaDTO buscarMateria(Long id) {
		return materiaMapper.ConvertirMateriaAMateriaDTO(materiaRepository.findById(id).get());
	}
	
}
