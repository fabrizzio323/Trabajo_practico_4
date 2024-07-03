package ar.edu.unju.fi.serviceImp;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;


public class AlumnoServiceImp implements AlumnoService{
    @Autowired
    private AlumnoRepository alumnoRepositpory;
    @Autowired
    private AlumnoMapper alumnoMap;
    
	@Override
	public void crearAlumno(AlumnoDTO alumnodto) {
		Alumno alumno = alumnoMap.ConvertirAlumnoDTOAAlumno(alumnodto);
		alumno.setEstado(true);
		alumnoRepositpory.save(alumno);
		
	}

	@Override
	public List<AlumnoDTO> mostrarALumnos() {
		List<AlumnoDTO> alumnosdto = new ArrayList<AlumnoDTO>();
		alumnosdto = alumnoMap.convertirListaAlumnoAListaAlumnoDTO(alumnoRepositpory.findAll());
		return null;
	}

	@Override
	public void eliminarAlumno(AlumnoDTO alumnodto) {
		Alumno alumno = alumnoMap.ConvertirAlumnoDTOAAlumno(alumnodto);
		alumno.setEstado(false);
		alumnoRepositpory.save(alumno);
		
	}

	@Override
	public void modificarAlumno(AlumnoDTO alumnodto) {
		Alumno alumno = alumnoMap.ConvertirAlumnoDTOAAlumno(alumnodto);
		alumno.setEstado(true);
		alumnoRepositpory.save(alumno);
		
	}

	@Override
	public AlumnoDTO buscarAlumno(Long id) {
		return alumnoMap.ConvertirAlumnoAAlumnoDTO(alumnoRepositpory.findById(id).get());
	}

}
