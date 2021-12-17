package mx.edu.utez.saps.service;

import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> 36668b1b019416d5ad96617a7869e0069fc6b738

import mx.edu.utez.saps.entity.BitacoraSolicitudEntity;
import mx.edu.utez.saps.repository.BitacoraSolicitudRepository;

<<<<<<< HEAD
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
=======
@Service
@Transactional
public class BitacoraSolicitudService {

	@Autowired
	private BitacoraSolicitudRepository bitacoraSolicitudRepository;
	
	public List<BitacoraSolicitudEntity> getBitacoras(){
		return bitacoraSolicitudRepository.findAll();
	}
	
	public BitacoraSolicitudEntity getBitacora(int idBitacoraSolicitud) {
		return bitacoraSolicitudRepository.findByIdBitacoraSolicitud(idBitacoraSolicitud);
	}
	
	public BitacoraSolicitudEntity save(BitacoraSolicitudEntity bitacoraSolicitud) {
		if (bitacoraSolicitudRepository.existsById(bitacoraSolicitudRepository.save(bitacoraSolicitud).getIdBitacoraSolicitud())) {
			return bitacoraSolicitudRepository.save(bitacoraSolicitud);
		} else {
			return null;
		}
	}
	
	public boolean delete(int idBitacoraSolicitud) {
		bitacoraSolicitudRepository.deleteById(idBitacoraSolicitud);
		return !bitacoraSolicitudRepository.existsById(idBitacoraSolicitud);
	}

	public List<BitacoraSolicitudEntity> getBitacorasByUsuario(int idUsuario) {
		return bitacoraSolicitudRepository.findAllBySolicitud_Solicitante_Usuario_IdUsuario(idUsuario);
	}
}
>>>>>>> 36668b1b019416d5ad96617a7869e0069fc6b738
