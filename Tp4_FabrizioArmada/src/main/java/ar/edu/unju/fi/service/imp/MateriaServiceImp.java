package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;

@Service
public class MateriaServiceImp implements IMateriaService {
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired
	private DocenteRepository docenteRepository;

	@Autowired
	private MateriaRepository materiaRepository; 
	
	@Autowired
	private MateriaMapper materiaMapper; 
	
    private static final Log LOGGER = LogFactory.getLog(AlumnoServiceImp.class);
	@Override
	public void crearMateria(MateriaDTO materiaDTO) {
		Materia materia = materiaMapper.ConvertirMateriaDTOAMateria(materiaDTO);
		
		Carrera carrera = carreraRepository.findById(materia.getCarrera().getId()).get();
		Docente docente = docenteRepository.findById(materia.getDocente().getId()).get();
		
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		materia.setEstado(true);
		materiaRepository.save(materia);
		LOGGER.info("Materia creada con exito");
	}

	@Override
	public List<MateriaDTO> listaMateria() {
		List<MateriaDTO> materiasDTO = materiaMapper.ConvertirListaMateriaAListaMateriaDTO(materiaRepository.findByEstado(true));
		LOGGER.info("Lista de materias");
		return materiasDTO;
	}

	@Override
	public void eliminarMateria(MateriaDTO materiaDTO) {
		Materia materia =  materiaMapper.ConvertirMateriaDTOAMateria(materiaDTO);
		materia.setEstado(false);
		materia.setDocente(null);
		materia.setCarrera(null);
		materiaRepository.save(materia);
		LOGGER.info("Materia eliminada con exito");
	}

	@Override
	public void modificarMateria(MateriaDTO materiaDTO) {
		Materia materia =  materiaMapper.ConvertirMateriaDTOAMateria(materiaDTO);
		
		Docente docente = docenteRepository.findById(materia.getCarrera().getId()).get();
		Carrera carrera = carreraRepository.findById(materia.getCarrera().getId()).get();
		
		materia.setDocente(docente);
		materia.setCarrera(carrera);
		
		materia.setEstado(true);
		materiaRepository.save(materia);
	    LOGGER.info("Materia modificada con exito");
	}

	@Override
	public MateriaDTO buscarMateria(Long id) {
		Optional<Materia> OpMateria = materiaRepository.findById(id);
		LOGGER.info("Busqueda en proceso");
		if(OpMateria.isPresent()) {
			Materia materia = OpMateria.get();
			MateriaDTO materiadto = materiaMapper.ConvertirMateriaAMateriaDTO(materia);
			LOGGER.info("Busqueda con exito");
			return materiadto;
		}else{
			return null;
		}
	}
	
}
