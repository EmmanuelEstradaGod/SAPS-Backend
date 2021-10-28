package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.CarreraEntity;
import mx.edu.utez.saps.repository.CarreraRepository;

@Service
@Transactional
public class CarreraService {

	@Autowired
	private CarreraRepository carreraRepository;
	
	public boolean saveCarrera(CarreraEntity carrera) {
		return carreraRepository.existsById(carreraRepository.save(carrera).getIdCarrera());
	}
	
	public boolean deleteCarrera(int idCarrera) {
		CarreraEntity carrera = carreraRepository.findByIdCarrera(idCarrera);
		carrera.setStatus(false);
		carreraRepository.save(carrera);
		return carreraRepository.existsById(idCarrera);
	}
	
	public List<CarreraEntity> getCarreras(){
		return carreraRepository.findAllByStatus(true);
	}
	
	public CarreraEntity getCarrera(int idCarrera) {
		return carreraRepository.findByIdCarrera(idCarrera);
	}
}
