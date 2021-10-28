package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BitacoraConsultaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBitacoraConsulta;
	@OneToOne
	private ConsultaEntity consulta;
	private boolean status;
	//---------------
	
	public int getIdBitacoraConsulta() {
		return idBitacoraConsulta;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdBitacoraConsulta(int idBitacoraConsulta) {
		this.idBitacoraConsulta = idBitacoraConsulta;
	}
	public ConsultaEntity getConsulta() {
		return consulta;
	}
	public void setConsulta(ConsultaEntity consulta) {
		this.consulta = consulta;
	}
	
}
