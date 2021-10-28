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

import mx.edu.utez.saps.entity.SintomaEntity;
import mx.edu.utez.saps.service.SintomaService;


@RestController
@CrossOrigin
@RequestMapping("/saps/sintoma")
public class SintomaController {
	
	@Autowired
	private SintomaService sintomaService;
	
	@PostMapping("/save")
	public boolean saveSintoma(@RequestBody SintomaEntity sintoma) {
		sintoma.setStatus(true);
		return sintomaService.saveSintoma(sintoma);
	}
	
	@PutMapping("/update")
	public boolean updateSintoma(@RequestBody SintomaEntity sintoma) {
		sintoma.setStatus(true);
		return sintomaService.saveSintoma(sintoma);
	}
	
	@DeleteMapping("/delete/{idSintoma}")
	public boolean deleteSintoma(@PathVariable("idSintoma") int idSintoma) {
		return sintomaService.deleteSintoma(idSintoma);
	}
	
	@GetMapping("/getAll")
	public List<SintomaEntity> getSintomas(){
		return sintomaService.getSintomas();
	}
	
	@GetMapping("/getOne/{idSintoma}")
	public SintomaEntity getSintoma(@PathVariable("idSintoma") int idSintoma){
		return sintomaService.getSintoma(idSintoma);
	}

}
