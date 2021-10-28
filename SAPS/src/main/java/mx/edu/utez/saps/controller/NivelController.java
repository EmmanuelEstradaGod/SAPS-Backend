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

import mx.edu.utez.saps.entity.NivelEntity;
import mx.edu.utez.saps.service.NivelService;

@RestController
@CrossOrigin
@RequestMapping("/saps/nivel")
public class NivelController {
	
	@Autowired
	private NivelService nivelService;
	
	@PostMapping("/save")
	public boolean saveNivel(@RequestBody NivelEntity nivel) {
		nivel.setStatus(true);
		return nivelService.saveNivel(nivel);
	}
	
	@DeleteMapping("/delete/{idNivel}")
	public boolean deleteNivel(@PathVariable("idNivel") int idNivel) {
		return nivelService.deleteNivel(idNivel);
	}
	
	@GetMapping("/getAll")
	public List<NivelEntity> getNiveles(){
		return nivelService.getNiveles();
	}
	
	@GetMapping("/getOne/{idNivel}")
	public NivelEntity getNivel(@PathVariable("idNivel") int idNivel){
		return nivelService.getNivel(idNivel);
	}
	
	@PutMapping("/update")
	public boolean updateNivel(@RequestBody NivelEntity nivel) {
		return nivelService.saveNivel(nivel);
	}
}