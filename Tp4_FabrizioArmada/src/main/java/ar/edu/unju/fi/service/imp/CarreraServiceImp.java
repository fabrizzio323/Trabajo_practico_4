package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;

@Service
public class CarreraServiceImp implements ICarreraService {

	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired
	private CarreraMapper carreraMapper; 
	
	@Override
	public void crearCarrera(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.convertirCarreraDTOaCarrera(carreraDTO);
		carrera.setEstado(true);
		carreraRepository.save(carrera);
	}

	@Override
	public List<CarreraDTO> listaCarreras() {
		List<CarreraDTO> carrerasDTO = carreraMapper.ConvertirListaCarreraAListaCarreraDTO(carreraRepository.findByEstado(true));
		return carrerasDTO;
	}
	
	@Override
	public void eliminarCarrera(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.convertirCarreraDTOaCarrera(carreraDTO);
		carrera.setEstado(false);
		carreraRepository.save(carrera);
	}

	@Override
	public void modificarCarrera(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.convertirCarreraDTOaCarrera(carreraDTO);
		carrera.setEstado(true);
		carreraRepository.save(carrera);
	}

	@Override
	public CarreraDTO buscarCarrera(Long id) {
		return carreraMapper.ConvertirCarreraACarreraDTO(carreraRepository.findById(id).get());
	}

}
