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

import mx.edu.utez.saps.entity.SolicitudAdministrativoEntity;
import mx.edu.utez.saps.entity.TipoUsuarioEntity;
import mx.edu.utez.saps.entity.UsuarioEntity;
import mx.edu.utez.saps.enums.TipoUsuario;
import mx.edu.utez.saps.service.SolicitudAdministrativoService;
import mx.edu.utez.saps.service.TipoUsuarioService;
import mx.edu.utez.saps.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/saps/solicitud/administrativo")
public class SolicitudAdmnistrativoController {
	
	@Autowired
	private SolicitudAdministrativoService solicitudAdministrativoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	@GetMapping("/getAll")
	public List<SolicitudAdministrativoEntity> getSolicitudesAdmnistrativos(){
		return solicitudAdministrativoService.getSolicitudesAdmnistrativos();
	}
	
	@GetMapping("/getOne/{idSolicitudAdministrativo}")
	public SolicitudAdministrativoEntity getSolicitudAdmnistrativo(@PathVariable("idSolicitudAdministrativo")int idSolicitudAdministrativo) {
		return solicitudAdministrativoService.getSolicitudAdmnistrativo(idSolicitudAdministrativo);
	}
	
	@PostMapping("/save/{idUsuario}")
	public boolean saveSolicitudAdmnistrativo(@RequestBody SolicitudAdministrativoEntity solicitudAdministrativo, @PathVariable("idUsuario") int idUsuario) {
		SolicitudAdministrativoEntity solicitud = solicitudAdministrativoService.saveSolicitudAdmnistrativo(solicitudAdministrativo);
		
		TipoUsuarioEntity tipoUsuario = new TipoUsuarioEntity();
		tipoUsuario.setSolicitudAdministrativo(solicitud);
		tipoUsuario.setTipoUsuario(TipoUsuario.Administrativo);
		tipoUsuario = tipoUsuarioService.saveTipoUsuario(tipoUsuario);
		
		UsuarioEntity usuario = usuarioService.getUsuario(idUsuario);
		usuario.setTipoUsuario(tipoUsuario);
		usuarioService.updateUsuario(usuario);
		
		return true;
	}
	
	@PutMapping("/update")
	public boolean updateSolicitudAdmnistrativo(@RequestBody SolicitudAdministrativoEntity solicitudAdministrativo) {
		solicitudAdministrativo.setStatus(true);
		solicitudAdministrativoService.saveSolicitudAdmnistrativo(solicitudAdministrativo);
		return true;
	}
	
	@DeleteMapping("/delete/{idSolicitudAdministrativo}")
	public boolean deleteSolicitudAdmnistrativo(@PathVariable("idSolicitudAdministrativo") int idSolicitudAdministrativo) {
		return solicitudAdministrativoService.deleteSolicitudAdmnistrativo(idSolicitudAdministrativo);
	}
}
