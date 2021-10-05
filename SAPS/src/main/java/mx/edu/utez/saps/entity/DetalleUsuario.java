package mx.edu.utez.saps.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DetalleUsuario implements UserDetails{
	
	private String correo;
	private String password;
	
	private GrantedAuthority authority;
	
	
	public DetalleUsuario(String correo, String password, GrantedAuthority authority) {
		super();
		this.correo = correo;
		this.password = password;
		this.authority = authority;
	}

	public static DetalleUsuario construir(UsuarioEntity usuario) {
		GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRole().getRole().name());
		return new DetalleUsuario(usuario.getCorreo(), usuario.getPassword(), authority);
	}
	
	//-------------------------------------------

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
