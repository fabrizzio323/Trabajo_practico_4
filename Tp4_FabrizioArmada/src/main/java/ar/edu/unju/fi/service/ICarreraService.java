package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;

public interface ICarreraService {

	public void crearCarrera(CarreraDTO carreraDTO);
	public List<CarreraDTO> listaCarreras();
	public void eliminarCarrera(Long id);
	public void modificarCarrera(CarreraDTO carreraDTO)  throws Exception;
	public CarreraDTO buscarCarrera(Long id);

}
