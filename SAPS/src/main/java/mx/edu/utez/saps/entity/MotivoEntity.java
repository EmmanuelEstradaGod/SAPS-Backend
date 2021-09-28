package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MotivoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMotivo;
	private String motivo;
	//---------------
	public int getIdMotivo() {
		return idMotivo;
	}
	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
