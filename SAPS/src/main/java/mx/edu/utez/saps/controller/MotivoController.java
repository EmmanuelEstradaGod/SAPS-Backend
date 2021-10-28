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

import mx.edu.utez.saps.entity.MotivoEntity;
import mx.edu.utez.saps.service.MotivoService;


@RestController
@CrossOrigin
@RequestMapping("/saps/motivo")
public class MotivoController {
	
	@Autowired
	private MotivoService motivoService;
	
	@PostMapping("/save")
	public boolean saveMotivo(@RequestBody MotivoEntity motivo) {
		motivo.setStatus(true);
		return motivoService.saveMotivo(motivo);
	}
	
	@PutMapping("/update")
	public boolean updateMotivo(@RequestBody MotivoEntity motivo) {
		return motivoService.saveMotivo(motivo);
	}
	
	@DeleteMapping("/delete/{idMotivo}")
	public boolean deleteMotivo(@PathVariable("idMotivo") int idMotivo) {
		return motivoService.deleteMotivo(idMotivo);
	}
	
	@GetMapping("/getAll")
	public List<MotivoEntity> getMotivos(){
		return motivoService.getMotivos();
	}
	
	@GetMapping("/getOne/{idMotivo}")
	public MotivoEntity getMotivo(@PathVariable("idMotivo") int idMotivo){
		return motivoService.getMotivo(idMotivo);
	}
}
