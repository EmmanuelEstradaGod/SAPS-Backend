package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SintomaEntity {
	
	
	public SintomaEntity() {
		super();
	}
	public SintomaEntity(String sintoma, boolean status) {
		super();
		this.sintoma = sintoma;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSintoma;
	private String sintoma;
	private boolean status;
	//---------------
	
	public int getIdSintoma() {
		return idSintoma;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdSintoma(int idSintoma) {
		this.idSintoma = idSintoma;
	}
	public String getSintoma() {
		return sintoma;
	}
	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
	
}
