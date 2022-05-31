package org.serratec.backend.projeto05.Controller;

import javax.mail.MessagingException;

import org.serratec.backend.projeto05.DTO.CartaoDTO;
import org.serratec.backend.projeto05.exception.EmailException;
import org.serratec.backend.projeto05.service.CartaoService;
import org.serratec.backend.projeto05.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	CartaoService cartaoService;
	
	@GetMapping("/email")
	public void enaviarEmail(CartaoDTO cartaoDTO) throws MessagingException, EmailException{
		emailService.emailTeste(cartaoDTO);
	}
}
