package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SolicitudAdministrativoEntity {
	
	
	public SolicitudAdministrativoEntity() {
		super();
	}
	public SolicitudAdministrativoEntity(DepartamentoEntity departamento, boolean status) {
		super();
		this.departamento = departamento;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolicitudAdministrativo;
	@ManyToOne
	private DepartamentoEntity departamento;
	private boolean status;
	//---------------
	
	public int getIdSolicitudAdministrativo() {
		return idSolicitudAdministrativo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdSolicitudAdministrativo(int idSolicitudAdministrativo) {
		this.idSolicitudAdministrativo = idSolicitudAdministrativo;
	}
	public DepartamentoEntity getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoEntity departamento) {
		this.departamento = departamento;
	}
	
}
