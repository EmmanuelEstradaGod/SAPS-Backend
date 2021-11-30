package mx.edu.utez.saps.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SolicitudEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolicitud;
	private Date fecha;
	@ManyToOne
	private SolicitanteEntity solicitante;
	private String estado;
	@ManyToMany
	private List<MotivoEntity> motivos;
	@ManyToMany
	private List<SintomaEntity> sintomas;
	@ManyToOne
	private ConsultorEntity consultor;
	private boolean status;
	//---------------
	
	public int getIdSolicitud() {
		return idSolicitud;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public SolicitanteEntity getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(SolicitanteEntity solicitante) {
		this.solicitante = solicitante;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<MotivoEntity> getMotivos() {
		return motivos;
	}
	public void setMotivos(List<MotivoEntity> motivos) {
		this.motivos = motivos;
	}
	public List<SintomaEntity> getSintomas() {
		return sintomas;
	}
	public void setSintomas(List<SintomaEntity> sintomas) {
		this.sintomas = sintomas;
	}
	
}
