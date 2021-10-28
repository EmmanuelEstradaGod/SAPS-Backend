package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.SolicitudEstudianteEntity;
import mx.edu.utez.saps.repository.SolicitudEstudianteRepository;

@Service
@Transactional
public class SolicitudEstudianteService {
	
	@Autowired
	private SolicitudEstudianteRepository solicitudEstudianteRepository;
	
	public SolicitudEstudianteEntity saveSolicitudEstudiante(SolicitudEstudianteEntity solicitudEstudiante) {
		return solicitudEstudianteRepository.save(solicitudEstudiante);
	}
	
	public boolean deleteSolicitudEstudiante(int idSolicitudEstudiante) {
		SolicitudEstudianteEntity solicitudEstudiante = solicitudEstudianteRepository.findByIdSolicitudEstudiante(idSolicitudEstudiante);
		solicitudEstudiante.setStatus(false);
		solicitudEstudianteRepository.save(solicitudEstudiante);
		return solicitudEstudianteRepository.existsById(idSolicitudEstudiante);
	}
	
	public List<SolicitudEstudianteEntity> getSolicitudesEstudiante(){
		return solicitudEstudianteRepository.findAllByStatus(true);
	}
	
	public SolicitudEstudianteEntity getSolicitudEstudiante(int idSolicitudEstudiante) {
		return solicitudEstudianteRepository.findByIdSolicitudEstudiante(idSolicitudEstudiante);
	}

}
