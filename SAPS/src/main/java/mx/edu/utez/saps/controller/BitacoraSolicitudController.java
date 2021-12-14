package mx.edu.utez.saps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.saps.entity.BitacoraSolicitudEntity;
import mx.edu.utez.saps.service.BitacoraSolicitudService;

@RestController
@CrossOrigin
@RequestMapping("/saps/bitacora/solicitud")
public class BitacoraSolicitudController {

	@Autowired
	private BitacoraSolicitudService bitacoraSolicitudService;
	
	@GetMapping("/getAll")
	public List<BitacoraSolicitudEntity> getBitacoras(){
		return bitacoraSolicitudService.getBitacoras();
	}
	
	@GetMapping("/getOne/{idBitacoraSolicitud}")
	public BitacoraSolicitudEntity getBitacora(@PathVariable("idBitacoraSolicitud") int idBitacoraSolicitud) {
		return bitacoraSolicitudService.getBitacora(idBitacoraSolicitud);
	}
	
	@GetMapping("/getAll/usuario/{idUsuario}")
	public List<BitacoraSolicitudEntity> getBitacorasByUsuario(@PathVariable("idUsuario") int idUsuario){
		return bitacoraSolicitudService.getBitacorasByUsuario(idUsuario);
	}
}
