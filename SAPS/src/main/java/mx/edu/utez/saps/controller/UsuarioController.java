package mx.edu.utez.saps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.saps.entity.UsuarioEntity;
import mx.edu.utez.saps.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/saps/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/getOne")
	public UsuarioEntity getOne(@RequestBody UsuarioEntity usuario) {
		return usuarioService.getUsuarioByCorreo(usuario.getCorreo());
	}
	
}
