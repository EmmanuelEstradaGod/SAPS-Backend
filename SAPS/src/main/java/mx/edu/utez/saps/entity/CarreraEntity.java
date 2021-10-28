package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CarreraEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrera;
	private String carrera;
	@ManyToOne
	private DivisionEntity division;
	private boolean status;
	//---------------
	
	public int getIdCarrera() {
		return idCarrera;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public DivisionEntity getDivision() {
		return division;
	}
	public void setDivision(DivisionEntity division) {
		this.division = division;
	}
	
}
