package mx.edu.utez.saps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.utez.saps.entity.BitacoraSolicitudEntity;
import mx.edu.utez.saps.repository.BitacoraSolicitudRepository;

public class BitacoraSolicitudService {
	
	@Autowired
	private BitacoraSolicitudRepository bitacoraSolicitudRepository;
	
	public boolean saveBitacoraSolicitud(BitacoraSolicitudEntity bitacoraSolicitud) {
		return bitacoraSolicitudRepository.existsById(bitacoraSolicitudRepository.save(bitacoraSolicitud).getIdBitacoraSolicitud());
	}
	
	public boolean deleteBitacoraSolicitud(int idBitacoraSolicitud) {
		bitacoraSolicitudRepository.deleteById(idBitacoraSolicitud);
		return !bitacoraSolicitudRepository.existsById(idBitacoraSolicitud);
	}
	
	public List<BitacoraSolicitudEntity> getBitacorasSolicitudes(){
		return bitacoraSolicitudRepository.findAll();
	}
	
	public BitacoraSolicitudEntity getBitacoraSolicitud(int idBitacoraSolicitud) {
		return bitacoraSolicitudRepository.findByIdBitacoraSolicitud(idBitacoraSolicitud);
	}
}