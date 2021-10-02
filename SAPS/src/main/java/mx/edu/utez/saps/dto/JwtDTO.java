package mx.edu.utez.saps.dto;

import org.springframework.security.core.GrantedAuthority;

public class JwtDTO {

	private String token;
	private String bearer = "Bearer";
	private String correo;
	private GrantedAuthority authority;
	
	public JwtDTO(String token, String bearer, String correo, GrantedAuthority authority) {
		super();
		this.token = token;
		this.bearer = bearer;
		this.correo = correo;
		this.authority = authority;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public GrantedAuthority getAuthority() {
		return authority;
	}

	public void setAuthority(GrantedAuthority authority) {
		this.authority = authority;
	}
	
	
		
}
