package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DivisionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDivision;
	private String division;
	//---------------
	public int getIdDivision() {
		return idDivision;
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
