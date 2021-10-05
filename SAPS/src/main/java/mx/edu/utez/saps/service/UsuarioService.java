package mx.edu.utez.saps.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.RoleEntity;
import mx.edu.utez.saps.entity.UsuarioEntity;
import mx.edu.utez.saps.enums.Role;
import mx.edu.utez.saps.repository.RoleRepository;
import mx.edu.utez.saps.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public boolean saveUsuario(UsuarioEntity usuario, Role  autoridad) {
		UsuarioEntity user = usuarioRepository.findByCorreo(usuario.getCorreo());
		if (user == null) {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			RoleEntity role = roleRepository.findByRole(autoridad);
			usuario.setRole(role);
			return usuarioRepository.existsById(usuarioRepository.save(usuario).getIdUsuario());

		}else {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			return usuarioRepository.existsById(usuarioRepository.save(usuario).getIdUsuario());
		}
		
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
