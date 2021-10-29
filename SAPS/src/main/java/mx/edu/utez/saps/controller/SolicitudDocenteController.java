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

import mx.edu.utez.saps.entity.SolicitudDocenteEntity;
import mx.edu.utez.saps.entity.TipoUsuarioEntity;
import mx.edu.utez.saps.entity.UsuarioEntity;
import mx.edu.utez.saps.enums.TipoUsuario;
import mx.edu.utez.saps.service.SolicitudDocenteService;
import mx.edu.utez.saps.service.TipoUsuarioService;
import mx.edu.utez.saps.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/saps/solicitud/docente")
public class SolicitudDocenteController {
	
	@Autowired
	private SolicitudDocenteService solicitudDocenteService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	@GetMapping("/getAll")
	public List<SolicitudDocenteEntity> getSolicitudesDocentes(){
		return solicitudDocenteService.getSolicitudesDocentes();
	}
	
	@GetMapping("/getOne/{idSolicitudDocente}")
	public SolicitudDocenteEntity getSolicitudDocente(@PathVariable("idSolicitudDocente")int idSolicitudDocente) {
		return solicitudDocenteService.getSolicitudDocente(idSolicitudDocente);
	}
	
	@PostMapping("/save/{idUsuario}")
	public boolean saveSolicitudDocente(@RequestBody SolicitudDocenteEntity solicitudDocente, @PathVariable("idUsuario") int idUsuario) {
		SolicitudDocenteEntity solicitud = solicitudDocenteService.saveSolicitudDocente(solicitudDocente);
		
		TipoUsuarioEntity tipoUsuario = new TipoUsuarioEntity();
		tipoUsuario.setSolicitudDocente(solicitud);
		tipoUsuario.setTipoUsuario(TipoUsuario.Docente);
		tipoUsuario = tipoUsuarioService.saveTipoUsuario(tipoUsuario);
		
		UsuarioEntity usuario = usuarioService.getUsuario(idUsuario);
		usuario.setTipoUsuario(tipoUsuario);
		usuarioService.updateUsuario(usuario);
		
		return true;
	}
	
	@PutMapping("/update")
	public boolean updateSolicitudDocente(@RequestBody SolicitudDocenteEntity solicitudDocente) {
		solicitudDocente.setStatus(true);
		solicitudDocenteService.saveSolicitudDocente(solicitudDocente);
		return true;
	}
	
	@DeleteMapping("/delete/{idSolicitudDocente}")
	public boolean deleteSolicitudDocente(@PathVariable("idSolicitudDocente") int idSolicitudDocente) {
		return solicitudDocenteService.deleteSolicitudDocente(idSolicitudDocente);
	}
}
