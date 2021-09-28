package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NivelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNivel;
	private String nivel;
	// ---------------
	public int getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	

}
