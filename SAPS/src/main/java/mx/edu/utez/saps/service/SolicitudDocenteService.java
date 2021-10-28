package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.SolicitudDocenteEntity;
import mx.edu.utez.saps.repository.SolicitudDocenteRepository;

@Service
@Transactional
public class SolicitudDocenteService {
	
	@Autowired
	private SolicitudDocenteRepository solicitudDocenteRepository;
	
	public SolicitudDocenteEntity saveSolicitudDocente(SolicitudDocenteEntity solicitudDocente) {
		return solicitudDocenteRepository.save(solicitudDocente);
	}
	
	public boolean deleteSolicitudDocente(int idSolicitudDocente) {
		solicitudDocenteRepository.deleteById(idSolicitudDocente);
		return !solicitudDocenteRepository.existsById(idSolicitudDocente);
	}
	
	public List<SolicitudDocenteEntity> getSolicitudesDocentes(){
		return solicitudDocenteRepository.findAll();
	}
	
	public SolicitudDocenteEntity getSolicitudDocente(int idSolicitudDocente) {
		return solicitudDocenteRepository.findByIdSolicitudDocente(idSolicitudDocente);
	}
}
