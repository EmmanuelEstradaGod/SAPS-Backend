package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SolicitudAdministrativoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolicitudAdministrativo;
	@ManyToOne
	private DepartamentoEntity departamento;
	//---------------
	public int getIdSolicitudAdministrativo() {
		return idSolicitudAdministrativo;
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
