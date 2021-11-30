package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DivisionEntity {
	
	
	public DivisionEntity() {
		super();
	}
	public DivisionEntity(String division, boolean status) {
		super();
		this.division = division;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDivision;
	private String division;
	private boolean status;
	//---------------
	
	public int getIdDivision() {
		return idDivision;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdDivision(int idDivision) {
		this.idDivision = idDivision;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
}
