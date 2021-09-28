package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SolicitudDocenteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolicitudDocente;
	@ManyToOne
	private DivisionEntity division;
	//---------------
	public int getIdSolicitudDocente() {
		return idSolicitudDocente;
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
