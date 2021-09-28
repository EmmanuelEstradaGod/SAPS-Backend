package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import mx.edu.utez.saps.enums.Role;

@Entity
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	@Enumerated
	private Role role;
	//---------------
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
