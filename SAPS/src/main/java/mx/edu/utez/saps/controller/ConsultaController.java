package mx.edu.utez.saps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.saps.entity.BitacoraConsultaEntity;
import mx.edu.utez.saps.entity.BitacoraSolicitudEntity;
import mx.edu.utez.saps.entity.ConsultaEntity;
import mx.edu.utez.saps.entity.SolicitudEntity;
import mx.edu.utez.saps.service.BitacoraConsultaService;
import mx.edu.utez.saps.service.BitacoraSolicitudService;
import mx.edu.utez.saps.service.ConsultaService;
import mx.edu.utez.saps.service.SolicitudService;

@RestController
@CrossOrigin
@RequestMapping("/saps/consulta")
public class ConsultaController {
	
	@Autowired
	private SolicitudService solicitudService;
	
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private BitacoraConsultaService bitacoraConsultaService;
	
	@GetMapping("/getAll")
	public List<ConsultaEntity> getConsultas(){
		return consultaService.getConsultas();
	}
	
	@GetMapping("/getOne/{idConsulta}")
	public ConsultaEntity getConsulta(@PathVariable("idConsulta") int idConsulta) {
		return consultaService.getConsulta(idConsulta);
	}
	
	@PostMapping("/save")
	public boolean saveConsulta(@RequestBody ConsultaEntity consulta) {
		BitacoraConsultaEntity bitacoraConsulta = new BitacoraConsultaEntity();
		bitacoraConsulta.setStatus(true);
		bitacoraConsulta.setConsulta(consultaService.saveConsulta(consulta));
		SolicitudEntity solicitud = solicitudService.getSolicitud(bitacoraConsulta.getConsulta().getSolicitud().getIdSolicitud());
		solicitud.setEstado("Asignada");
		solicitudService.saveSolicitud(solicitud);
		return bitacoraConsultaService.saveBitacoraConsulta(bitacoraConsulta);
	}
	
	@PutMapping("/update")
	public ConsultaEntity updateConsulta(@RequestBody ConsultaEntity consulta) {
		return consultaService.saveConsulta(consulta);
	}
	
	@GetMapping("/getAll/usuario/{idUsuario}")
	public List<ConsultaEntity> getConsultasByUsuario(@PathVariable("idUsuario") int idUsuario){
		return consultaService.getConsultasByUsuario(idUsuario);
	}
	
	@GetMapping("/getAll/consultor/{idConsultor}")
	public List<ConsultaEntity> getConsultasByConsultor(@PathVariable("idConsultor") int idConsultor){
		return consultaService.getConsultasByConsultor(idConsultor);
	}

}
