package mx.edu.utez.saps.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.saps.dto.JwtDTO;
import mx.edu.utez.saps.dto.LoginUser;
import mx.edu.utez.saps.jwt.JwtProvider;
import mx.edu.utez.saps.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<JwtDTO> responseEntity(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return new ResponseEntity("Datos incompletos", HttpStatus.BAD_REQUEST);
		}
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginUser.getNickname(), loginUser.getPassword())
					);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = jwtProvider.generateToken(authentication);
			UserDetails details = (UserDetails) authentication.getPrincipal();
			JwtDTO jwtDTO = new JwtDTO(token, details.getUsername(), details.getAuthorities());
			
			return new ResponseEntity(jwtDTO,HttpStatus.OK);
		}catch (BadCredentialsException e) {
			return new ResponseEntity("Usuario y/o contraseña incorrectos",HttpStatus.BAD_REQUEST);
		}
	}
}
