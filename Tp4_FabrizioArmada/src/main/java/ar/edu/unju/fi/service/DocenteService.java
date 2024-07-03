package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

public interface DocenteService {
      public void guardarDocente(DocenteDTO docentedto);
      public List<DocenteDTO> mostrarDocentes();
      public void EliminarDocente(DocenteDTO docentedto);
      public void modificarDocente(DocenteDTO docentedto);
      public DocenteDTO buscarDocente(Long id);
       
}
