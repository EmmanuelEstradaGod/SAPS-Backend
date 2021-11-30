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

import mx.edu.utez.saps.entity.EstadoCivilEntity;
import mx.edu.utez.saps.service.EstadoCivilService;

@RestController
@CrossOrigin
@RequestMapping("/saps/estadoCivil")
public class EstadoCivilController {
	
	@Autowired
	private EstadoCivilService estadoCivilService;
	
	@PostMapping("/save")
	public boolean saveEstadoCivil(@RequestBody EstadoCivilEntity estadoCivil) {
		estadoCivil.setStatus(true);
		return estadoCivilService.saveEstadoCivil(estadoCivil);
	}
	
	@PutMapping("/update")
	public boolean updateEstadoCivil(@RequestBody EstadoCivilEntity estadoCivil) {
		estadoCivil.setStatus(true);
		return estadoCivilService.saveEstadoCivil(estadoCivil);
	}
	
	@DeleteMapping("/delete/{idEstadoCivil}")
	public boolean deleteEstadoCivil(@PathVariable("idEstadoCivil") int idEstadoCivil) {
		return estadoCivilService.deleteEstadoCivil(idEstadoCivil);
	}

	@GetMapping("/getAll")
	public List<EstadoCivilEntity> getEstadosCiviles(){
		return estadoCivilService.getEstadosCiviles();
	}
	
	@GetMapping("/getOne/{idEstadoCivil}")
	public EstadoCivilEntity getEstadoCivil(@PathVariable("idEstadoCivil") int idEstadoCivil) {
		return estadoCivilService.getEstadoCivil(idEstadoCivil);
	}
}
