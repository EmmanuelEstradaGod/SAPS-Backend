package mx.edu.utez.saps.dto;

import javax.validation.constraints.NotNull;

public class LoginUser {
	
	@NotNull
	private String nickname;
	@NotNull
	private String password;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginUser [nickname=" + nickname + ", password=" + password + "]";
	}
	
	
}
