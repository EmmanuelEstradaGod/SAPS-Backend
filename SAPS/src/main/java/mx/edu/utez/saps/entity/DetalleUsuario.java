package mx.edu.utez.saps.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DetalleUsuario implements UserDetails{
	
	private String correo;
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	
	

	public DetalleUsuario(String correo, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.correo = correo;
		this.password = password;
		this.authorities = authorities;
	}

	public static DetalleUsuario construir(UsuarioEntity usuario) {
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getRole().name()))
				.collect(Collectors.toList());
		return new DetalleUsuario(usuario.getCorreo(), usuario.getPassword(), authorities);
	}
	
	//-------------------------------------------

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return correo;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
