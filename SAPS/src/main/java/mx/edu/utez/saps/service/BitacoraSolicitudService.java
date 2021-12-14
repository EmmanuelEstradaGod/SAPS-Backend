package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.BitacoraSolicitudEntity;
import mx.edu.utez.saps.repository.BitacoraSolicitudRepository;

@Service
@Transactional
public class BitacoraSolicitudService {

	@Autowired
	private BitacoraSolicitudRepository bitacoraSolicitudRepository;
	
	public List<BitacoraSolicitudEntity> getAll(){
		return bitacoraSolicitudRepository.findAll();
	}
	
	public BitacoraSolicitudEntity getOne(int idBitacoraSolicitud) {
		return bitacoraSolicitudRepository.findByIdBitacoraSolicitud(idBitacoraSolicitud);
	}
	
	public boolean save(BitacoraSolicitudEntity bitacoraSolicitud) {
		return bitacoraSolicitudRepository.existsById(bitacoraSolicitudRepository.save(bitacoraSolicitud).getIdBitacoraSolicitud());
	}
	
	public boolean delete(int idBitacoraSolicitud) {
		bitacoraSolicitudRepository.deleteById(idBitacoraSolicitud);
		return !bitacoraSolicitudRepository.existsById(idBitacoraSolicitud);
	}
}
