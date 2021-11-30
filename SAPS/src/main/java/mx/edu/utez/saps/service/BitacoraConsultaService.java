package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.BitacoraConsultaEntity;
import mx.edu.utez.saps.repository.BitacoraConsultaRepository;

@Service
@Transactional
public class BitacoraConsultaService {
	
	@Autowired
	private BitacoraConsultaRepository bitacoraConsultaRepository;
	
	public List<BitacoraConsultaEntity> getBitacorasConsulta(){
		return bitacoraConsultaRepository.findAll();
	}
	
	public BitacoraConsultaEntity getBitacoraConsulta(int idBitacoraConsulta) {
		return bitacoraConsultaRepository.findByIdBitacoraConsulta(idBitacoraConsulta);
	}
	
	public boolean saveBitacoraConsulta(BitacoraConsultaEntity bitacoraConsulta) {
		return bitacoraConsultaRepository.existsById(bitacoraConsultaRepository.save(bitacoraConsulta).getIdBitacoraConsulta());
	}
	
	public List<BitacoraConsultaEntity> getBitacorasConsultaByUusuario(int idUsuario){
		return bitacoraConsultaRepository.findAllByConsulta_Solicitud_Solicitante_Usuario_IdUsuario(idUsuario);
	}

}
