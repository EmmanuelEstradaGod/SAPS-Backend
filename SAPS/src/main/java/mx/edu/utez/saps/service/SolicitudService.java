package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.SolicitudEntity;
import mx.edu.utez.saps.repository.SolicitudRepository;

@Service
@Transactional
public class SolicitudService {

	@Autowired
	private SolicitudRepository solicitudRepository;
	
	public List<SolicitudEntity> getSolicitudes(){
		return solicitudRepository.findAllByStatus(true);
	}
	
	public SolicitudEntity getSolicitud(int idSolicitud) {
		return solicitudRepository.findByIdSolicitud(idSolicitud);
	}
	
	public SolicitudEntity saveSolicitud(SolicitudEntity solicitud) {
		return solicitudRepository.save(solicitud);
	}
	
	public boolean deleteSolicitud(int idSolicitud) {
		SolicitudEntity solicitud = solicitudRepository.findByIdSolicitud(idSolicitud);
		solicitud.setStatus(false);
		solicitudRepository.save(solicitud);
		return solicitudRepository.existsById(idSolicitud);
	}
	
	public List<SolicitudEntity> getSolicitudesByUsuario(int idUsuario){
		return solicitudRepository.findAllBySolicitante_Usuario_IdUsuario(idUsuario);
	}
}
