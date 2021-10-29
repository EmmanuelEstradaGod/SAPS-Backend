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

import mx.edu.utez.saps.entity.ConsultorEntity;
import mx.edu.utez.saps.service.ConsultorService;

@RestController
@CrossOrigin
@RequestMapping("/saps/consultor")
public class ConsultorController {
	
	@Autowired
	private ConsultorService consultorService;
	
	@PostMapping("/save")
	public boolean saveConsultor(@RequestBody ConsultorEntity consultor) {
		consultor.setStatus(true);
		return consultorService.saveConsultor(consultor);
	}
	
	@PutMapping("/update")
	public boolean updateConsultor(@RequestBody ConsultorEntity consultor) {
		consultor.setStatus(true);
		return consultorService.saveConsultor(consultor);
	}
	
	@DeleteMapping("/delete/{idConsultor}")
	public boolean deleteConsultor(@PathVariable("idConsultor") int idConsultor) {
		return consultorService.deleteConsultor(idConsultor);
	}

	@GetMapping("/getAll")
	public List<ConsultorEntity> getConsultores(){
		return consultorService.getConsultores();
	}
	
	@GetMapping("/getOne/{idConsultor}")
	public ConsultorEntity getConsultor(@PathVariable("idConsultor") int idConsultor) {
		return consultorService.getConsultor(idConsultor);
	}
}
