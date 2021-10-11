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

import mx.edu.utez.saps.entity.SolicitudEstudianteEntity;
import mx.edu.utez.saps.service.SolicitudEstudianteService;

@RestController
@CrossOrigin
@RequestMapping("/saps/solicitud/estudiante")
public class SolicitudEstudianteController {

	@Autowired
	private SolicitudEstudianteService solicitudEstudianteService;
	
	@GetMapping("/getAll")
	public List<SolicitudEstudianteEntity> getSolicitudesEstudiante(){
		return solicitudEstudianteService.getSolicitudesEstudiante();
	}
	
	@GetMapping("/getOne/{idSolicitudEstudiante}")
	public SolicitudEstudianteEntity getSolicitudEstudiante(@PathVariable("idSolicitudEstudiante")int idSolicitudEstudiante) {
		return solicitudEstudianteService.getSolicitudEstudiante(idSolicitudEstudiante);
	}
	
	@PostMapping("/save")
	public boolean saveSolicitudEstudiante(@RequestBody SolicitudEstudianteEntity solicitudEstudiante) {
		return solicitudEstudianteService.saveSolicitudEstudiante(solicitudEstudiante);
	}
	
	@PutMapping("/update")
	public boolean updateSolicitudEstudiante(@RequestBody SolicitudEstudianteEntity solicitudEstudiante) {
		return solicitudEstudianteService.saveSolicitudEstudiante(solicitudEstudiante);
	}
	
	@DeleteMapping("/delete/{idSolicitudEstudiante}")
	public boolean deleteSolicitudEstudiante(@PathVariable("idSolicitudEstudiante") int idSolicitudEstudiante) {
		return solicitudEstudianteService.deleteSolicitudEstudiante(idSolicitudEstudiante);
	}
}
