package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.SolicitudAdministrativoEntity;
import mx.edu.utez.saps.repository.SolicitudAdmnistrativoRepository;


@Service
@Transactional
public class SolicitudAdministrativoService {
	
	@Autowired
	private SolicitudAdmnistrativoRepository solicitudAdmnistrativoRepository;
	
	public SolicitudAdministrativoEntity saveSolicitudAdmnistrativo(SolicitudAdministrativoEntity solicitudAdministrativo) {
		return solicitudAdmnistrativoRepository.save(solicitudAdministrativo);
	}
	
	public boolean deleteSolicitudAdmnistrativo(int idSolicitudAdministrativo) {
		solicitudAdmnistrativoRepository.deleteById(idSolicitudAdministrativo);
		return !solicitudAdmnistrativoRepository.existsById(idSolicitudAdministrativo);
	}
	
	public List<SolicitudAdministrativoEntity> getSolicitudesAdmnistrativos(){
		return solicitudAdmnistrativoRepository.findAll();
	}
	
	public SolicitudAdministrativoEntity getSolicitudAdmnistrativo(int idSolicitudAdministrativo) {
		return solicitudAdmnistrativoRepository.findByIdSolicitudAdministrativo(idSolicitudAdministrativo);
	}
}
