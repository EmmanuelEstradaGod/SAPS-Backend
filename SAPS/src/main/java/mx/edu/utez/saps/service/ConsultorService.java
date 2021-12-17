package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.ConsultorEntity;
import mx.edu.utez.saps.repository.ConsultorRepository;

@Service
@Transactional
public class ConsultorService {
	
	@Autowired
	private ConsultorRepository consultorRepository;
	
	public boolean saveConsultor(ConsultorEntity consultor) {
		return consultorRepository.existsById(consultorRepository.save(consultor).getIdConsultor());
	}
	
	public boolean deleteConsultor(int idConsultor) {
		ConsultorEntity consultor = consultorRepository.findByIdConsultor(idConsultor);
		consultor.setStatus(false);
		consultorRepository.save(consultor);
		return consultorRepository.existsById(idConsultor);
	}
	
	public List<ConsultorEntity> getConsultores() {
		return consultorRepository.findAllByStatus(true);
	}
	
	public ConsultorEntity getConsultor(int idConsultor) {
		return consultorRepository.findByIdConsultor(idConsultor);
	}
	
	public ConsultorEntity getConsultorByIdUsuario(int idUsuario) {
		return consultorRepository.findByUsuario_IdUsuario(idUsuario);
	}
}
