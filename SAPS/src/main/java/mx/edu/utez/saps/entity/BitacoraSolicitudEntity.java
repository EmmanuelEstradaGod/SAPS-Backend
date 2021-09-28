package mx.edu.utez.saps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BitacoraSolicitudEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBitacoraSolicitud;
	@OneToOne
	private SolicitudEntity solicitud;
	//---------------
	public int getIdBitacoraSolicitud() {
		return idBitacoraSolicitud;
	}
	public void setIdBitacoraSolicitud(int idBitacoraSolicitud) {
		this.idBitacoraSolicitud = idBitacoraSolicitud;
	}
	public SolicitudEntity getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(SolicitudEntity solicitud) {
		this.solicitud = solicitud;
	}
	
}
