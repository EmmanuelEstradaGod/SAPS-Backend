package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.SolicitanteEntity;
import mx.edu.utez.saps.repository.SolicitanteRepository;

@Service
@Transactional
public class SolicitanteService {

	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	public List<SolicitanteEntity> getSolicitantes(){
		return solicitanteRepository.findAll();
	}
	
	public SolicitanteEntity getSolicitante(int idSolicitante) {
		return solicitanteRepository.findByIdSolicitante(idSolicitante);
	}
	
	public boolean saveSolicitante(SolicitanteEntity solicitante) {
		return solicitanteRepository.existsById(solicitanteRepository.save(solicitante).getIdSolicitante());
	}
	
	public boolean deleteSolicitante(int idSolicitante) {
		solicitanteRepository.deleteById(idSolicitante);
		return !solicitanteRepository.existsById(idSolicitante);
	}
}
