package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.TipoUsuarioEntity;
import mx.edu.utez.saps.repository.TipoUsuarioRepository;

@Service
@Transactional
public class TipoUsuarioService {
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	public List<TipoUsuarioEntity> getTiposUsuario(){
		return tipoUsuarioRepository.findAllByStatus(true);
	}
	
	public TipoUsuarioEntity getTipoUsuario(int idTipoUsuario) {
		return tipoUsuarioRepository.findByIdTipoUsuario(idTipoUsuario);
	}
	
	public TipoUsuarioEntity saveTipoUsuario(TipoUsuarioEntity tipoUsuario) {
		return tipoUsuarioRepository.save(tipoUsuario);
	}
	
	public boolean deleteTipoUsuario(int idTipoUsuario) {
		TipoUsuarioEntity tipoUsuario = tipoUsuarioRepository.findByIdTipoUsuario(idTipoUsuario);
		tipoUsuario.setStatus(false);
		tipoUsuarioRepository.save(tipoUsuario);
		return tipoUsuarioRepository.existsById(idTipoUsuario);
	}
}
