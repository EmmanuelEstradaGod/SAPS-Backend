package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.ConsultaEntity;
import mx.edu.utez.saps.repository.ConsultaRepository;

@Service
@Transactional
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public List<ConsultaEntity> getConsultas(){
		return consultaRepository.findAll();
	}
	
	public ConsultaEntity getConsulta(int idConsulta) {
		return consultaRepository.findByIdConsulta(idConsulta);
	}
	
	public ConsultaEntity saveConsulta(ConsultaEntity consulta) {
		return consultaRepository.save(consulta);
	}
	
	public List<ConsultaEntity> getConsultasByUsuario(int idUsuario){
		return consultaRepository.findAllBySolicitud_Solicitante_Usuario_IdUsuario(idUsuario);
	}
	
	public List<ConsultaEntity> getConsultasByConsultor(int idConsultor){
		return consultaRepository.findAllByConsultor_IdConsultor(idConsultor);
	}
}
