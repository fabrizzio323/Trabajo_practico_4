package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;

public interface IMateriaService {

	public void crearMateria(MateriaDTO materiaDTO);
	public List<MateriaDTO> listaMateria();
	public void eliminarMateria(Long id);
	public void modificarMateria(MateriaDTO materiaDTO);
	public MateriaDTO buscarMateria(Long id);

}
