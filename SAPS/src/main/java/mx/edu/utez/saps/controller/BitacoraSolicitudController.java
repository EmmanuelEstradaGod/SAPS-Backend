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
import mx.edu.utez.saps.service.BitacoraSolicitudService;

@RestController
@CrossOrigin
@RequestMapping("/saps/bitacora/solicitud")
public class BitacoraSolicitudController {
	
	@Autowired
	private BitacoraSolicitudService bitacoraSolicitudService;
	
	@PostMapping("/save")
	public boolean saveBitacoraSolicitud(@RequestBody BitacoraSolicitudEntity bitacoraSolicitud) {
		bitacoraSolicitud.setStatus(true);
		return bitacoraSolicitudService.saveBitacoraSolicitud(bitacoraSolicitud);
	}
	
	@DeleteMapping("/delete/{idBitacoraSolicitud}")
	public boolean deleteBitacoraSolicitud(@PathVariable("idBitacoraSolicitud") int idBitacoraSolicitud) {
		return bitacoraSolicitudService.deleteBitacoraSolicitud(idBitacoraSolicitud);
	}
	
	@GetMapping("/getAll")
	public List<BitacoraSolicitudEntity> getBitacorasSolicitudes(){
		return bitacoraSolicitudService.getBitacorasSolicitudes();
	}
	
	@GetMapping("/getOne/{idBitacoraSolicitud}")
	public BitacoraSolicitudEntity getBitacoraSolicitud(@PathVariable("idBitacoraSolicitud") int idBitacoraSolicitud){
		return bitacoraSolicitudService.getBitacoraSolicitud(idBitacoraSolicitud);
	}
	
	@PutMapping("/update")
	public boolean updateBitacoraSolicitud(@RequestBody BitacoraSolicitudEntity bitacoraSolicitud) {
		bitacoraSolicitud.setStatus(true);
		return bitacoraSolicitudService.saveBitacoraSolicitud(bitacoraSolicitud);
	}
}
