package mx.edu.utez.saps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.saps.entity.DivisionEntity;
import mx.edu.utez.saps.service.DivisionService;

@RestController
@CrossOrigin
@RequestMapping("/saps/division")
public class DivisionController {
	@Autowired
	private DivisionService divisionService;
	
	@PostMapping("/save")
	public boolean saveDivision(@RequestBody DivisionEntity division) {
		return divisionService.saveDivision(division);
	}
	
	@DeleteMapping("/delete")
	public boolean deleteDivision(@RequestBody int idDivision) {
		return divisionService.deleteDivision(idDivision);
	}

	@GetMapping("/getAll")
	public List<DivisionEntity> getDivisiones(){
		return divisionService.getDivisiones();
	}
	
	@GetMapping("/getOne")
	public DivisionEntity getDivision(@RequestBody int idDivision) {
		return divisionService.getDivision(idDivision);
	}
	
	@PutMapping("/update")
	public boolean updateDivision(@RequestBody DivisionEntity division) {
		return divisionService.saveDivision(division);
	}
}
