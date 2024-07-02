package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;

@Service("carreraServiceMysql")
public class CarreraServiceImp implements ICarreraService {

	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired
	private CarreraMapper carreraMapper; 
	
	@Override
	public void crearCarrera(CarreraDTO carreraDTO) {
		carreraRepository.save(carreraMapper.convertirCarreraDTOaCarrera(carreraDTO));
	}

	@Override
	public List<CarreraDTO> listaCarreras() {
		List<CarreraDTO> carrerasDTO = carreraMapper.ConvertirListaCarreraAListaCarreraDTO(carreraRepository.findAll());
		return carrerasDTO;
	}
	
	@Override
	public void eliminarCarrera(Long codigo) {
		carreraRepository.deleteById(codigo);
	}

	@Override
	public void modificarCarrera(CarreraDTO carreraDTO) throws Exception {
		carreraRepository.save(carreraMapper.convertirCarreraDTOaCarrera(carreraDTO));
	}

	@Override
	public CarreraDTO buscarCarrera(Long codigo) {
		return carreraMapper.ConvertirCarreraACarreraDTO(carreraRepository.findById(codigo).get());
	}

}
