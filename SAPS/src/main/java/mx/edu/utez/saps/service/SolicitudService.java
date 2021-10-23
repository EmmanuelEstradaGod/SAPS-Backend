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
		return solicitudRepository.findAll();
	}
	
	public SolicitudEntity getSolicitud(int idSolicitud) {
		return solicitudRepository.findByIdSolicitud(idSolicitud);
	}
	
	public boolean saveSolicitud(SolicitudEntity solicitud) {
		return solicitudRepository.existsById(solicitudRepository.save(solicitud).getIdSolicitud());
	}
	
	public boolean deleteSolicitud(int idSolicitud) {
		solicitudRepository.deleteById(idSolicitud);
		return !solicitudRepository.existsById(idSolicitud);
	}
	
	public List<SolicitudEntity> getSolicitudesByUsuario(int idUsuario){
		return solicitudRepository.findAllBySolicitante_Usuario_IdUsuario(idUsuario);
	}
}
