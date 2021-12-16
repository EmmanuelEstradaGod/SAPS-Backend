package mx.edu.utez.saps.entity;

import java.sql.Date;

public class ProrrogaConsulta {

	private int idConsulta;
	private Date fecha;
	
	
	//--------------------
	
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
