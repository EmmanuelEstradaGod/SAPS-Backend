package mx.edu.utez.saps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 36668b1b019416d5ad96617a7869e0069fc6b738
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.saps.entity.BitacoraSolicitudEntity;
import mx.edu.utez.saps.service.BitacoraSolicitudService;

@RestController
@CrossOrigin
@RequestMapping("/saps/bitacora/solicitud")
public class BitacoraSolicitudController {
<<<<<<< HEAD
	
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
=======

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
>>>>>>> 36668b1b019416d5ad96617a7869e0069fc6b738
	}
}
