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
import mx.edu.utez.saps.service.BitacoraConsultaService;

@RestController
@CrossOrigin
@RequestMapping("/saps/bitacora/consulta")
public class BitacoraConsultaController {

	@Autowired
	private BitacoraConsultaService bitacoraConsultaService;
	
	@GetMapping("/getAll")
	public List<BitacoraConsultaEntity> getBitacorasConsulta(){
		return bitacoraConsultaService.getBitacorasConsulta();
	}
	
	@GetMapping("/getOne/{idBitacoraConsulta}")
	public BitacoraConsultaEntity getBitacoraConsulta(@PathVariable("idBitacoraConsulta") int idBitacoraConsulta) {
		return bitacoraConsultaService.getBitacoraConsulta(idBitacoraConsulta);
	}
	
	@PostMapping("/save")
	public boolean saveBitacoraConsulta(@RequestBody BitacoraConsultaEntity bitacoraConsulta) {
		return bitacoraConsultaService.saveBitacoraConsulta(bitacoraConsulta);
	}
	
	@PutMapping("/update")
	public boolean updateBitacoraConsulta(@RequestBody BitacoraConsultaEntity bitacoraConsulta) {
		return bitacoraConsultaService.saveBitacoraConsulta(bitacoraConsulta);
	}
	
	@GetMapping("/getAll/usuario/{idUsuario}")
	public List<BitacoraConsultaEntity> getBitacorasConsultaByUsuario(@PathVariable("idUsuario") int idUsuario){
		return bitacoraConsultaService.getBitacorasConsultaByUusuario(idUsuario);
	}
}
