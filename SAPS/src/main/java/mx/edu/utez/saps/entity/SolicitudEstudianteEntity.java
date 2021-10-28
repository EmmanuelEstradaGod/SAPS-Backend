package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SolicitudEstudianteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolicitudEstudiante;
	private String matricula;
	@ManyToOne
	private NivelEntity nivelEstudio;
	@ManyToOne
	private CarreraEntity carrera;
	private String grado;
	private String grupo;
	private String tutor;
	private boolean status;
	//---------------
	
	public int getIdSolicitudEstudiante() {
		return idSolicitudEstudiante;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIdSolicitudEstudiante(int idSolicitudEstudiante) {
		this.idSolicitudEstudiante = idSolicitudEstudiante;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public NivelEntity getNivelEstudio() {
		return nivelEstudio;
	}
	public void setNivelEstudio(NivelEntity nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}
	public CarreraEntity getCarrera() {
		return carrera;
	}
	public void setCarrera(CarreraEntity carrera) {
		this.carrera = carrera;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	
}
