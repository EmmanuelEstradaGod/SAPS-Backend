package mx.edu.utez.saps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.saps.entity.BitacoraSolicitudEntity;
import mx.edu.utez.saps.entity.ConsultaEntity;
import mx.edu.utez.saps.entity.SolicitudEntity;
import mx.edu.utez.saps.service.BitacoraSolicitudService;
import mx.edu.utez.saps.service.SolicitudService;

@RestController
@CrossOrigin
@RequestMapping("/saps/solicitud")
public class SolicitudController {

	@Autowired
	private SolicitudService solicitudService;
	@Autowired
	private BitacoraSolicitudService bitacoraSolicitudService;
	
	@GetMapping("/getAll")
	public List<SolicitudEntity> getSolicitudes(){
		return solicitudService.getSolicitudes();
	}
	
	@GetMapping("/getOne/{idSolicitud}")
	public SolicitudEntity getSolicitud(@PathVariable("idSolicitud") int idSolicitud) {
		return solicitudService.getSolicitud(idSolicitud);
	}
	
	@PostMapping("/save")
	public int saveSolicitud(@RequestBody SolicitudEntity solicitud) {
		solicitud.setStatus(true);
		BitacoraSolicitudEntity bitacoraSolicitud = new BitacoraSolicitudEntity();
		bitacoraSolicitud.setStatus(true);
		bitacoraSolicitud.setSolicitud(solicitudService.saveSolicitud(solicitud));
		return bitacoraSolicitudService.save(bitacoraSolicitud).getIdBitacoraSolicitud();
	}
	
	@DeleteMapping("/delete/{idSolicitud}")
	public boolean deleteSolicitud(@PathVariable("idSolicitud") int idSolicitud) {
		return solicitudService.deleteSolicitud(idSolicitud);
	}
	
	@PutMapping("/update")
	public boolean updateSolicitud(@RequestBody SolicitudEntity solicitud) {
		solicitud.setStatus(true);
		solicitudService.saveSolicitud(solicitud);
		return true;
	}
	
	@GetMapping("getAll/usuario/{idUsuario}")
	public List<SolicitudEntity> getSolicitudesByUsuario(@PathVariable("idUsuario") int idUsuario){
		return solicitudService.getSolicitudesByUsuario(idUsuario);
	}
}
