package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.UsuarioEntity;
import mx.edu.utez.saps.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public boolean saveUsuario(UsuarioEntity usuario) {
		return usuarioRepository.existsById(usuarioRepository.save(usuario).getIdUsuario());
	}
	
	public boolean deleteUsuario(int idUsuario) {
		usuarioRepository.deleteById(idUsuario);
		return !usuarioRepository.existsById(idUsuario);
	}
	
	public List<UsuarioEntity> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public UsuarioEntity getUsuario(int idUsuario) {
		return usuarioRepository.findByIdUsuario(idUsuario);
	}
	
	public UsuarioEntity getUsuarioByCorreo(String correo) {
		return usuarioRepository.findByCorreo(correo);
	}

}
