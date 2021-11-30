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

import mx.edu.utez.saps.entity.ConsultaEntity;
import mx.edu.utez.saps.service.ConsultaService;

@RestController
@CrossOrigin
@RequestMapping("/saps/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;
	
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
		return consultaService.saveConsulta(consulta);
	}
	
	@PutMapping("/update")
	public boolean updateConsulta(@RequestBody ConsultaEntity consulta) {
		return consultaService.saveConsulta(consulta);
	}
	
	@GetMapping("/getAll/usuario/{idUsuario}")
	public List<ConsultaEntity> getConsultasByUsuario(@PathVariable("idUsuario") int idUsuario){
		return consultaService.getConsultasByUsuario(idUsuario);
	}

}
