package mx.edu.utez.saps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String to, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(to);
		message.setSubject("Envío de enlace para consulta de apoyo psicopedagógico");
		message.setText(content);
		
		javaMailSender.send(message);
	}

}
