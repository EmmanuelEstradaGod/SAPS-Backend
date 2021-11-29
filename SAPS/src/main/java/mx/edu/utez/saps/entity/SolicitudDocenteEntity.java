package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SolicitudDocenteEntity {
	
	
	public SolicitudDocenteEntity() {
		super();
	}
	public SolicitudDocenteEntity(DivisionEntity division, boolean status) {
		super();
		this.division = division;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolicitudDocente;
	@ManyToOne
	private DivisionEntity division;
	private boolean status;
	//---------------
	
	public int getIdSolicitudDocente() {
		return idSolicitudDocente;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdSolicitudDocente(int idSolicitudDocente) {
		this.idSolicitudDocente = idSolicitudDocente;
	}
	public DivisionEntity getDivision() {
		return division;
	}
	public void setDivision(DivisionEntity division) {
		this.division = division;
	}
	
}
