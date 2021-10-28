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
import mx.edu.utez.saps.entity.TipoUsuarioEntity;
import mx.edu.utez.saps.entity.UsuarioEntity;
import mx.edu.utez.saps.enums.TipoUsuario;
import mx.edu.utez.saps.service.SolicitudEstudianteService;
import mx.edu.utez.saps.service.TipoUsuarioService;
import mx.edu.utez.saps.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/saps/solicitud/estudiante")
public class SolicitudEstudianteController {

	@Autowired
	private SolicitudEstudianteService solicitudEstudianteService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	@GetMapping("/getAll")
	public List<SolicitudEstudianteEntity> getSolicitudesEstudiante(){
		return solicitudEstudianteService.getSolicitudesEstudiante();
	}
	
	@GetMapping("/getOne/{idSolicitudEstudiante}")
	public SolicitudEstudianteEntity getSolicitudEstudiante(@PathVariable("idSolicitudEstudiante")int idSolicitudEstudiante) {
		return solicitudEstudianteService.getSolicitudEstudiante(idSolicitudEstudiante);
	}
	
	@PostMapping("/save/{idUsuario}")
	public boolean saveSolicitudEstudiante(@RequestBody SolicitudEstudianteEntity solicitudEstudiante,@PathVariable("idUsuario") int idUsuario) {
		solicitudEstudiante.setStatus(true);
		SolicitudEstudianteEntity solicitud = solicitudEstudianteService.saveSolicitudEstudiante(solicitudEstudiante);
		
		TipoUsuarioEntity tipoUsuario = new TipoUsuarioEntity();
		tipoUsuario.setStatus(true);
		tipoUsuario.setSolicitudEstudiante(solicitud);
		tipoUsuario.setTipoUsuario(TipoUsuario.Estudiante);
		tipoUsuario = tipoUsuarioService.saveTipoUsuario(tipoUsuario);
		
		UsuarioEntity usuario = usuarioService.getUsuario(idUsuario);
		usuario.setTipoUsuario(tipoUsuario);
		usuarioService.updateUsuario(usuario);
		
		return true;
	}
	
	@PutMapping("/update")
	public boolean updateSolicitudEstudiante(@RequestBody SolicitudEstudianteEntity solicitudEstudiante) {
		solicitudEstudiante.setStatus(true);
		solicitudEstudianteService.saveSolicitudEstudiante(solicitudEstudiante);
		return true;
	}
	
	@DeleteMapping("/delete/{idSolicitudEstudiante}")
	public boolean deleteSolicitudEstudiante(@PathVariable("idSolicitudEstudiante") int idSolicitudEstudiante) {
		return solicitudEstudianteService.deleteSolicitudEstudiante(idSolicitudEstudiante);
	}
}
