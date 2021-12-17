package mx.edu.utez.saps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.saps.entity.ConsultaEntity;
import mx.edu.utez.saps.entity.Mail;
import mx.edu.utez.saps.service.ConsultaService;
import mx.edu.utez.saps.service.EmailService;

@RestController
@CrossOrigin
@RequestMapping("/saps/mail")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	@Autowired ConsultaService consultaService;
	
	@PostMapping("/send")
	public void send(@RequestBody Mail mail) {
		ConsultaEntity consulta = consultaService.getConsulta(mail.getIdConsulta());
		String fecha= consulta.getSolicitud().getFecha().toString();
		
		String content = "Se ha establecido el siguiente enlace con la llamada para la sesión de Apoyo Psicopedagógico\n"
				+ "Fecha y hora: "+fecha.replace('T', ' ')+" \n"
				+ "Enlace: "+ mail.getLinkCall();
		emailService.sendMail(mail.getTo(), content);
	}

}
