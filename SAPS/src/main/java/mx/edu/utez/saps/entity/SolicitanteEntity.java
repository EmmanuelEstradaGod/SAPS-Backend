package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SolicitanteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolicitante;
	@OneToOne
	private UsuarioEntity usuario;
	private int edad;
	private String domicilio;
	@ManyToOne
	private EstadoCivilEntity estadoCivil;
	private String telefonoApoyo;
	private String nombreApoyo;
	private String parentezcoApoyo;
	private String personasVivienda;
	//---------------
	public int getIdSolicitante() {
		return idSolicitante;
	}
	public void setIdSolicitante(int idSolicitante) {
		this.idSolicitante = idSolicitante;
	}
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public EstadoCivilEntity getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivilEntity estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getTelefonoApoyo() {
		return telefonoApoyo;
	}
	public void setTelefonoApoyo(String telefonoApoyo) {
		this.telefonoApoyo = telefonoApoyo;
	}
	public String getNombreApoyo() {
		return nombreApoyo;
	}
	public void setNombreApoyo(String nombreApoyo) {
		this.nombreApoyo = nombreApoyo;
	}
	public String getParentezcoApoyo() {
		return parentezcoApoyo;
	}
	public void setParentezcoApoyo(String parentezcoApoyo) {
		this.parentezcoApoyo = parentezcoApoyo;
	}
	public String getPersonasVivienda() {
		return personasVivienda;
	}
	public void setPersonasVivienda(String personasVivienda) {
		this.personasVivienda = personasVivienda;
	}
	
}
