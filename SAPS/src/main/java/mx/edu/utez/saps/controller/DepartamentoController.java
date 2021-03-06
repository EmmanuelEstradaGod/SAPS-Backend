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

import mx.edu.utez.saps.entity.DepartamentoEntity;

import mx.edu.utez.saps.service.DepartamentoService;

@RestController
@CrossOrigin
@RequestMapping("/saps/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@PostMapping("/save")
	public boolean saveDepartamento(@RequestBody DepartamentoEntity departamento) {
		return departamentoService.saveDepartamento(departamento);
	}
	
	@DeleteMapping("/delete/{idDepartamento}")
	public boolean deleteDepartamento(@PathVariable("idDepartamento") int idDepartamento) {
		return departamentoService.deleteDepartamento(idDepartamento);
	}
	
	@GetMapping("/getAll")
	public List<DepartamentoEntity> getDepartamentos(){
		return departamentoService.getDepartamentos();
	}
	
	@GetMapping("/getOne/{idDepartamento}")
	public DepartamentoEntity getDepartamento(@PathVariable("idDepartamento") int idDepartamento){
		return departamentoService.getDepartamento(idDepartamento);
	}
	
	@PutMapping("/update")
	public boolean updateDepartamento(@RequestBody DepartamentoEntity departamento) {
		return departamentoService.saveDepartamento(departamento);
	}
}
