package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.MotivoEntity;
import mx.edu.utez.saps.repository.MotivoRepository;


@Service
@Transactional
public class MotivoService {
	
	@Autowired
	private MotivoRepository motivoRepository;
	
	public boolean saveMotivo(MotivoEntity motivo) {
		return motivoRepository.existsById(motivoRepository.save(motivo).getIdMotivo());
	}
	
	public boolean deleteMotivo(int idMotivo) {
		motivoRepository.deleteById(idMotivo);
		return !motivoRepository.existsById(idMotivo);
	}
	
	public List<MotivoEntity> getMotivos(){
		return motivoRepository.findAll();
	}
	
	public MotivoEntity getMotivo(int idMotivo) {
		return motivoRepository.findByIdMotivo(idMotivo);
	}
}
