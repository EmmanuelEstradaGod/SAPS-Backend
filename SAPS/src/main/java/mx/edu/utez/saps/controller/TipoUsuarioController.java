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

import mx.edu.utez.saps.entity.TipoUsuarioEntity;
import mx.edu.utez.saps.enums.TipoUsuario;
import mx.edu.utez.saps.service.TipoUsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/saps/tipo-usuario")
public class TipoUsuarioController {

	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	@GetMapping("/getAll")
	public List<TipoUsuarioEntity> getTiposUsuario(){
		return tipoUsuarioService.getTiposUsuario();
	}
	
	@GetMapping("/getOne/{idTipoUsuario}")
	public TipoUsuarioEntity getTipoUsuario(@PathVariable("idTipoUsuario") int idTipoUsuario) {
		return tipoUsuarioService.getTipoUsuario(idTipoUsuario);
	}
	
	@PostMapping("/save/estudiante")
	public TipoUsuarioEntity saveTipoUsuarioEstudiante(@RequestBody TipoUsuarioEntity tipoUsuario) {
		tipoUsuario.setStatus(true);
		tipoUsuario.setTipoUsuario(TipoUsuario.Estudiante);
		return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
	}
	
	@PostMapping("/save/docente")
	public TipoUsuarioEntity saveTipoUsuarioDocente(@RequestBody TipoUsuarioEntity tipoUsuario) {
		tipoUsuario.setStatus(true);
		tipoUsuario.setTipoUsuario(TipoUsuario.Docente);
		return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
	}
	
	@PostMapping("/save/administrativo")
	public TipoUsuarioEntity saveTipoUsuarioAdministrativo(@RequestBody TipoUsuarioEntity tipoUsuario) {
		tipoUsuario.setStatus(true);
		tipoUsuario.setTipoUsuario(TipoUsuario.Administrativo);
		return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
	}
	
	@PutMapping("/update")
	public TipoUsuarioEntity updateTipoUsuario(@RequestBody TipoUsuarioEntity tipoUsuario) {
		tipoUsuario.setStatus(true);
		return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
	}
	
	@DeleteMapping("/delete/{idTipoUsuario}")
	public boolean deleteTipoUsuario(@PathVariable("idTipoUsuario") int idTipoUsuario) {
		return tipoUsuarioService.deleteTipoUsuario(idTipoUsuario);
	}
}
