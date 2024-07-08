package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService{
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private AlumnoMapper alumnoMap;
    
    private static final Log LOGGER = LogFactory.getLog(AlumnoServiceImp.class);
    
	@Override
	public void crearAlumno(AlumnoDTO alumnodto) {
		Alumno alumno = alumnoMap.ConvertirAlumnoDTOAAlumno(alumnodto);
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
		LOGGER.info("Alumno creado con exito");
	}

	@Override
	public List<AlumnoDTO> mostrarALumnos() {
		List<AlumnoDTO> alumnosdto = new ArrayList<AlumnoDTO>();
		alumnosdto = alumnoMap.convertirListaAlumnoAListaAlumnoDTO(alumnoRepository.findByEstado(true));
    LOGGER.info("Lista de alumnos");
    return alumnosdto;
	} 

	@Override
	public void eliminarAlumno(Long id) {
		Alumno alumno = alumnoRepository.findById(id).get();
		alumno.setEstado(false);
		alumnoRepository.save(alumno);
		LOGGER.info("Alumno eliminado con exito");
	}

	@Override
	public void modificarAlumno(AlumnoDTO alumnodto) {
		Alumno alumno = alumnoMap.ConvertirAlumnoDTOAAlumno(alumnodto);
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
		LOGGER.info("Alumno modificado con exito");
	}

	@Override
	public AlumnoDTO buscarAlumno(Long id) {
		Optional<Alumno> OpALumno = alumnoRepository.findById(id);
		LOGGER.info("Busqueda en proceso");
		if(OpALumno.isPresent()) {
			Alumno encontrado = OpALumno.get();
			AlumnoDTO alumnodto = alumnoMap.ConvertirAlumnoAAlumnoDTO(encontrado);
			LOGGER.info("Busqueda exitosa");
		return alumnodto;
		}else {
		return null;
		}
	}

}
