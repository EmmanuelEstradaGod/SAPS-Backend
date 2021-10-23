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

import mx.edu.utez.saps.entity.SolicitanteEntity;
import mx.edu.utez.saps.service.SolicitanteService;

@RestController
@CrossOrigin
@RequestMapping("/saps/solicitante")
public class SolicitanteController {
	
	@Autowired
	private SolicitanteService solicitanteService;

	@GetMapping("/getAll")
	public List<SolicitanteEntity> getSolicitantes(){
		return solicitanteService.getSolicitantes();
	}
	
	@GetMapping("/getOne/{idSolicitante}")
	public SolicitanteEntity getSolicitante(@PathVariable("idSolicitante") int idSolicitante) {
		return solicitanteService.getSolicitante(idSolicitante);
	}
	
	@PostMapping("/save")
	public boolean saveSolicitante(@RequestBody SolicitanteEntity solicitante) {
		return solicitanteService.saveSolicitante(solicitante);
	}
	
	@DeleteMapping("/delete/{idSolicitante}")
	public boolean deleteSolicitante(@PathVariable("idSolicitante") int idSolicitante) {
		return solicitanteService.deleteSolicitante(idSolicitante);
	}
	
	@PutMapping("/update")
	public boolean updateSolicitante(@RequestBody SolicitanteEntity solicitante) {
		return solicitanteService.saveSolicitante(solicitante);
	}
	
}
