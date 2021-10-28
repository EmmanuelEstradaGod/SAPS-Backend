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

import mx.edu.utez.saps.entity.CarreraEntity;
import mx.edu.utez.saps.service.CarreraService;

@RestController
@CrossOrigin
@RequestMapping("/saps/carrera")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;
	
	@PostMapping("/save")
	public boolean saveCarrera(@RequestBody CarreraEntity carrera) {
		carrera.setStatus(true);
		return carreraService.saveCarrera(carrera);
	}
	
	@DeleteMapping("/delete/{idCarrera}")
	public boolean deleteCarrera(@PathVariable("idCarrera") int idCarrera) {
		return carreraService.deleteCarrera(idCarrera);
	}
	
	@GetMapping("/getAll")
	public List<CarreraEntity> getCarreras(){
		return carreraService.getCarreras();
	}
	
	@GetMapping("/getOne/{idCarrera}")
	public CarreraEntity getCarrera(@PathVariable("idCarrera") int idCarrera){
		return carreraService.getCarrera(idCarrera);
	}
	
	@PutMapping("/update")
	public boolean updateCarrera(@RequestBody CarreraEntity carrera) {
		return carreraService.saveCarrera(carrera);
	}
}
