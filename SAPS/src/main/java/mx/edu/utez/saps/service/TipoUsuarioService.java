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
		return tipoUsuarioRepository.findAll();
	}
	
	public TipoUsuarioEntity getTipoUsuario(int idTipoUsuario) {
		return tipoUsuarioRepository.findByIdTipoUsuario(idTipoUsuario);
	}
	
	public boolean saveTipoUsuario(TipoUsuarioEntity tipoUsuario) {
		return tipoUsuarioRepository.existsById(tipoUsuarioRepository.save(tipoUsuario).getIdTipoUsuario());
	}
	
	public boolean deleteTipoUsuario(int idTipoUsuario) {
		tipoUsuarioRepository.deleteById(idTipoUsuario);
		return !tipoUsuarioRepository.existsById(idTipoUsuario);
	}
}
