package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;

public interface AlumnoService {
     public void crearAlumno(AlumnoDTO alumnodto);
     public List<AlumnoDTO> mostrarALumnos();
     public void eliminarAlumno(Long id);
     public void modificarAlumno(AlumnoDTO alumnodto);
     public AlumnoDTO buscarAlumno(Long id);
}
