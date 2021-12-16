package mx.edu.utez.saps.entity;

import java.sql.Date;
import java.time.LocalDateTime;

public class ProrrogaConsulta {

	private int idConsulta;
	private LocalDateTime fecha;
	
	
	//--------------------
	
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
}
