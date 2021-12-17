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
<<<<<<< HEAD
import mx.edu.utez.saps.entity.SolicitudEntity;
import mx.edu.utez.saps.service.BitacoraConsultaService;
import mx.edu.utez.saps.service.BitacoraSolicitudService;
=======
import mx.edu.utez.saps.entity.ProrrogaConsulta;
import mx.edu.utez.saps.entity.SolicitudEntity;
>>>>>>> d4002d00b83821852f1bd4fd978e2818439b6262
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
	private SolicitudService solicitudService;
	
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
	
<<<<<<< HEAD
	@GetMapping("/getAll/consultor/{idConsultor}")
	public List<ConsultaEntity> getConsultasByConsultor(@PathVariable("idConsultor") int idConsultor){
		return consultaService.getConsultasByConsultor(idConsultor);
=======
	@PostMapping("/save/prorroga")
	public boolean saveProrroga(@RequestBody ProrrogaConsulta prorrogaConsulta) {
		ConsultaEntity consulta = consultaService.getConsulta(prorrogaConsulta.getIdConsulta());
		ConsultaEntity nuevaConsulta = new ConsultaEntity();
		nuevaConsulta.setConsultor(consulta.getConsultor());
		nuevaConsulta.setEstado(consulta.getEstado());
		
		SolicitudEntity solicitud = solicitudService.getSolicitud(consulta.getSolicitud().getIdSolicitud());
		SolicitudEntity nuevaSolicitud = new SolicitudEntity();
		nuevaSolicitud.setFecha(prorrogaConsulta.getFecha());
		nuevaSolicitud.setSolicitante(solicitud.getSolicitante());
		nuevaSolicitud.setEstado("Prorroga");
		nuevaSolicitud.setMotivos(solicitud.getMotivos());
		nuevaSolicitud.setSintomas(solicitud.getSintomas());
		nuevaSolicitud.setConsultor(solicitud.getConsultor());
		nuevaSolicitud.setStatus(solicitud.isStatus());
		
		nuevaConsulta.setSolicitud(solicitudService.saveSolicitud(nuevaSolicitud));
		consultaService.saveConsulta(nuevaConsulta);
		return true;
>>>>>>> d4002d00b83821852f1bd4fd978e2818439b6262
	}

}
