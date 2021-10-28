package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mx.edu.utez.saps.entity.NivelEntity;
import mx.edu.utez.saps.repository.NivelRepository;

@Service
@Transactional
public class NivelService {
	@Autowired
	private NivelRepository nivelRepository;
	
	public boolean saveNivel(NivelEntity nivel) {
		return nivelRepository.existsById(nivelRepository.save(nivel).getIdNivel());
	}
	
	public boolean deleteNivel(int idNivel) {
		NivelEntity nivel = nivelRepository.findByIdNivel(idNivel);
		nivel.setStatus(false);
		nivelRepository.save(nivel);
		return nivelRepository.existsById(idNivel);
	}
	
	public List<NivelEntity> getNiveles(){
		return nivelRepository.findAllByStatus(true);
	}
	
	public NivelEntity getNivel(int idNivel) {
		return (NivelEntity) nivelRepository.findByIdNivel(idNivel);
	}
}
