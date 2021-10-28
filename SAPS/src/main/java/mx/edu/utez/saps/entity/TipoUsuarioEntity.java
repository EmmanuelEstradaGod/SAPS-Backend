package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import mx.edu.utez.saps.enums.TipoUsuario;

@Entity
public class TipoUsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoUsuario;
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	@OneToOne
	private SolicitudEstudianteEntity solicitudEstudiante;
	@OneToOne
	private SolicitudDocenteEntity solicitudDocente;
	@OneToOne
	private SolicitudAdministrativoEntity solicitudAdministrativo;
	private boolean status;
	//---------------
	
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public SolicitudEstudianteEntity getSolicitudEstudiante() {
		return solicitudEstudiante;
	}
	public void setSolicitudEstudiante(SolicitudEstudianteEntity solicitudEstudiante) {
		this.solicitudEstudiante = solicitudEstudiante;
	}
	public SolicitudDocenteEntity getSolicitudDocente() {
		return solicitudDocente;
	}
	public void setSolicitudDocente(SolicitudDocenteEntity solicitudDocente) {
		this.solicitudDocente = solicitudDocente;
	}
	public SolicitudAdministrativoEntity getSolicitudAdministrativo() {
		return solicitudAdministrativo;
	}
	public void setSolicitudAdministrativo(SolicitudAdministrativoEntity solicitudAdministrativo) {
		this.solicitudAdministrativo = solicitudAdministrativo;
	}
	
}
