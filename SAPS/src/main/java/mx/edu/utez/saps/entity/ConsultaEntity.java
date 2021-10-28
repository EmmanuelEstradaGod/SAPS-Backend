package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ConsultaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsulta;
	@OneToOne
	private ConsultorEntity consultor;
	@OneToOne
	private SolicitudEntity solicitud;
	private String estado;
	private boolean status;
	//---------------
	
	public int getIdConsulta() {
		return idConsulta;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public ConsultorEntity getConsultor() {
		return consultor;
	}
	public void setConsultor(ConsultorEntity consultor) {
		this.consultor = consultor;
	}
	public SolicitudEntity getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(SolicitudEntity solicitud) {
		this.solicitud = solicitud;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
