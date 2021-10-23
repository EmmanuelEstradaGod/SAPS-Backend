package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.EstadoCivilEntity;
import mx.edu.utez.saps.repository.EstadoCivilRepository;

@Service
@Transactional
public class EstadoCivilService {
	
	@Autowired
	private EstadoCivilRepository estadoCivilRepository;
	
	public boolean saveEstadoCivil(EstadoCivilEntity estadoCivil) {
		return estadoCivilRepository.existsById(estadoCivilRepository.save(estadoCivil).getIdEstadoCivil());
	}
	
	public boolean deleteEstadoCivil(int idEstadoCivil) {
		estadoCivilRepository.deleteById(idEstadoCivil);
		return !estadoCivilRepository.existsById(idEstadoCivil);
	}
	
	public List<EstadoCivilEntity> getEstadosCiviles() {
		return estadoCivilRepository.findAll();
	}
	
	public EstadoCivilEntity getEstadoCivil(int idEstadoCivil) {
		return estadoCivilRepository.findByIdEstadoCivil(idEstadoCivil);
	}
}
