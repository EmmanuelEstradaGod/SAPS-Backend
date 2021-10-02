package mx.edu.utez.saps.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.edu.utez.saps.entity.DetalleUsuario;
import mx.edu.utez.saps.entity.UsuarioEntity;

@Service
@Transactional
public class DetalleUsuarioService implements UserDetailsService{
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity usuario = usuarioService.getUsuarioByCorreo(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return DetalleUsuario.construir(usuario);
	}

}
